package com.wajahat.service.stockdata.rest.handler;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.core.service.api.QuoteService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Component
public class QuotesHandler {
    private QuoteService quoteService;

    public QuotesHandler(QuoteService quoteService) {
        this.quoteService = requireNonNull(quoteService);
    }

    public List<Quote> getBySymbol(String symbol) {
        if (!getAllSymbols().contains(symbol))
            return Collections.emptyList();

        return quoteService.findBySymbol(symbol);
    }

    public List<Quote> getAll() {
        return quoteService.findAll();
    }

    public boolean create(Quote quote) {
        return quoteService.create(quote);
    }

    public boolean update(Quote quote) {
        return quoteService.update(quote);
    }

    public boolean delete(String symbol) {
        return quoteService.delete(symbol);
    }

    public Set<String> getAllSymbols() {
        return quoteService.findAllSymbols();
    }
}
