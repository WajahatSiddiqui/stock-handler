package com.wajahat.service.stockcontroller.core.scheduler;

import com.wajahat.service.stockcontroller.config.StockControllerConfig;
import com.wajahat.service.stockcontroller.core.domain.AlphaVantageQuote;
import com.wajahat.service.stockcontroller.core.domain.Quote;
import com.wajahat.service.stockcontroller.core.service.QuoteService;
import com.wajahat.service.stockcontroller.core.service.QuotesControllerProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Objects.requireNonNull;

/**
 * QuoteScheduler
 *
 * @author Wajahat Siddiqui
 */
@Component
@Slf4j
public class QuoteScheduler {

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    @Value("${routing.key}")
    private String routingKey;

    public QuoteService quoteService;
    private RabbitTemplate rabbitTemplate;
    private QuotesControllerProxy quotesControllerProxy;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public QuoteScheduler(QuoteService quoteService,
                          RabbitTemplate rabbitTemplate,
                          QuotesControllerProxy quotesControllerProxy) {
        this.quoteService = requireNonNull(quoteService);
        this.rabbitTemplate = requireNonNull(rabbitTemplate);
        this.quotesControllerProxy = requireNonNull(quotesControllerProxy);
    }

    @Scheduled(cron = "${quote.cron.expr}")
    public void saveQuoteDetails() throws InterruptedException, ExecutionException {
        // find all the quotes
        // update the quotes in the table
        Objects.requireNonNull(quotesControllerProxy.getAllSymbols().getBody()).forEach(symbol -> {
            log.info("******* Saving Quote [" + symbol + "] **********");
            Future<AlphaVantageQuote> future = executorService.submit(new GetQuote(symbol, quoteService));
            while (true) {
                if (future.isCancelled() || future.isDone()) break;
            }
            AlphaVantageQuote alphaVantageQuote = null;
            try {
                alphaVantageQuote = future.get();
                if (alphaVantageQuote != null) {
                    executorService.submit(new SendQuote(Quote.builder().compositeKey(Quote.CompositeKey.builder()
                            .symbol(alphaVantageQuote.getGlobalQuote().getSymbol())
                            .timestamp(Timestamp.valueOf(LocalDateTime.now())).build())
                            .open(alphaVantageQuote.getGlobalQuote().getOpen())
                            .low(alphaVantageQuote.getGlobalQuote().getLow())
                            .high(alphaVantageQuote.getGlobalQuote().getHigh())
                            .price(alphaVantageQuote.getGlobalQuote().getPrice())
                            .changePercentage(Double.valueOf(alphaVantageQuote.getGlobalQuote().getChange_percent().substring(0, alphaVantageQuote.getGlobalQuote().getChange_percent().length() - 1)))
                            .build(), rabbitTemplate, fanoutExchange, routingKey));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static class GetQuote implements Callable<AlphaVantageQuote> {
        private String symbol;
        private QuoteService quoteService;
        public GetQuote(String symbol, QuoteService quoteService) {
            this.symbol = symbol;
            this.quoteService = quoteService;
        }
        @Override
        public AlphaVantageQuote call() {
            log.info("Fetching the quote: " + symbol + " from server ...");
            return quoteService.getQuote(symbol);
        }
    }

    private static class SendQuote implements Runnable {
        private Quote quote;
        private RabbitTemplate rabbitTemplate;
        String fanoutExchange;
        String routingKey;
        public SendQuote(Quote quote, RabbitTemplate rabbitTemplate, String fanoutExchange, String routingKey) {
            this.quote = quote;
            this.rabbitTemplate = rabbitTemplate;
            this.fanoutExchange = fanoutExchange;
            this.routingKey = routingKey;
        }

        @Override
        public void run() {
            log.info("Sending the quote: "+ quote + " to stock-data in rabbitmq message");
            rabbitTemplate.convertAndSend(fanoutExchange,
                    routingKey, quote);
        }
    }
}
