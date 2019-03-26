package com.wajahat.service.stockdata.core.service.api;

import com.wajahat.service.stockdata.core.domain.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> findBySymbol(String symbol);
}
