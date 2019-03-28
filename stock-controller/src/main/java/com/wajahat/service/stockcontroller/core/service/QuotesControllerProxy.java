package com.wajahat.service.stockcontroller.core.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Feign Client for Quote Service
 *
 * @author Wajahat Siddiqui
 */
@FeignClient(name = "stock-data")
public interface QuotesControllerProxy {
    @RequestMapping(value = "/quotes/symbols", method = RequestMethod.GET)
    ResponseEntity<Set<String>> getAllSymbols();
}
