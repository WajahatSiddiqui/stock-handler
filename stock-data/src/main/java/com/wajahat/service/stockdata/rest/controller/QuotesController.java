package com.wajahat.service.stockdata.rest.controller;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.rest.handler.QuotesHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/quotes")
public class QuotesController {

    private QuotesHandler quotesHandler;

    public QuotesController(QuotesHandler quotesHandler) {
        this.quotesHandler = requireNonNull(quotesHandler);
    }

    @GetMapping()
    ResponseEntity<List<Quote>> getBySymbol(@RequestParam("symbol") String symbol) {
        return ResponseEntity.ok(quotesHandler.getBySymbol(symbol));
    }
}
