package com.wajahat.service.stockviewer.rest.controller;

import com.wajahat.service.stockviewer.core.domain.Quote;
import com.wajahat.service.stockviewer.core.service.QuotesControllerProxy;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Quotes Controller
 *
 * @author Wajahat Siddiqui
 */
@RefreshScope
@RestController
@RequestMapping("/api")
public class QuotesController {
    private QuotesControllerProxy quotesControllerProxy;

    public QuotesController(QuotesControllerProxy quotesControllerProxy) {
        this.quotesControllerProxy = requireNonNull(quotesControllerProxy);
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getBySymbol(@RequestParam(name = "symbol") String symbol) {
        return quotesControllerProxy.getBySymbol(symbol);
    }
}
