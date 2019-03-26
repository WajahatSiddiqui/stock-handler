package com.wajahat.service.stockdata.rest.handler;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.core.service.api.QuoteService;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Component
public class QuotesHandler {
    private QuoteService quoteService;

    public QuotesHandler(QuoteService quoteService) {
        this.quoteService = requireNonNull(quoteService);
    }

    public List<Quote> getBySymbol(String symbol) {
        // ToDo validate symbol
        return quoteService.findBySymbol(symbol);
    }
}
