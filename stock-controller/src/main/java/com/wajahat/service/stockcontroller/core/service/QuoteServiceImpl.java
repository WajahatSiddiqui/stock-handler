package com.wajahat.service.stockcontroller.core.service;

import com.wajahat.service.stockcontroller.core.domain.AlphaVantageQuote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static java.util.Objects.requireNonNull;

/**
 * ${CLASS_NAME}
 *
 * @author Wajahat Siddiqui
 */
@Service
public class QuoteServiceImpl implements QuoteService {
    @Value("${alphavantage.uri}")
    private String alphaVantageUri;

    @Value("${alphavantage.query}")
    private String query;

    @Value("${alphavantage.function}")
    private String function;

    @Value("${alphavantage.function_value}")
    private String function_value;

    @Value("${alphavantage.symbol}")
    private String symbol;

    @Value("${alphavantage.apikey}")
    private String apikey;

    @Value("${alphavantage.apikey_value}")
    private String apikey_value;

    String getUri(String symbol_value) {
        StringBuilder builder = new StringBuilder();
        return builder
                .append("/")
                .append(query)
                .append("?")
                .append(function)
                .append("=")
                .append(function_value)
                .append("&")
                .append(symbol)
                .append("=")
                .append(symbol_value)
                .append("&")
                .append(apikey)
                .append("=")
                .append(apikey_value).toString();
    }

    @Override
    public AlphaVantageQuote getQuote(String symbol) {
        // ToDo create asyn client
        return WebClient.create(alphaVantageUri)
                .get()
                .uri(getUri(symbol))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(res->res.bodyToMono(AlphaVantageQuote.class))
                .block();
    }
}
