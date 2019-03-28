package com.wajahat.service.stockdata.core.service.api;

import com.wajahat.service.stockdata.core.domain.Quote;

import java.util.List;
import java.util.Set;

public interface QuoteService {
    List<Quote> findAll();
    List<Quote> findBySymbol(String symbol);
    Set<String> findAllSymbols();
    boolean create(Quote quote);
    boolean update(Quote quote);
    boolean delete(String symbol);
}
