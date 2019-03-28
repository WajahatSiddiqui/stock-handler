package com.wajahat.service.stockcontroller.core.service;

import com.wajahat.service.stockcontroller.core.domain.AlphaVantageQuote;

/**
 * ${CLASS_NAME}
 *
 * @author Wajahat Siddiqui
 */
public interface QuoteService {
    AlphaVantageQuote getQuote(String symbol);
}
