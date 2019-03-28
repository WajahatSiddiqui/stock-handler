package com.wajahat.service.stockviewer.core.service;

import com.wajahat.service.stockviewer.core.domain.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign Client for Quote Service
 *
 * @author Wajahat Siddiqui
 */
@FeignClient(name = "stock-data")
public interface QuotesControllerProxy {
    @RequestMapping(value = "/quotes", method = RequestMethod.GET)
    ResponseEntity<List<Quote>> getBySymbol(@RequestParam(name = "symbol") String symbol);
}
