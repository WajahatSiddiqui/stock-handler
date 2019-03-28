package com.wajahat.service.stockdata.rest.controller;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.rest.exception.InvalidParameterException;
import com.wajahat.service.stockdata.rest.handler.QuotesHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/quotes")
public class QuotesController {

    private QuotesHandler quotesHandler;

    public QuotesController(QuotesHandler quotesHandler) {
        this.quotesHandler = requireNonNull(quotesHandler);
    }

    @GetMapping()
    ResponseEntity<List<Quote>> getBySymbol(@RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(quotesHandler.getBySymbol(symbol));
    }

    /**
     * @return All quotes data
     * ToDo Need to page this
     */
    @GetMapping("/all")
    ResponseEntity<List<Quote>> getAll() {
        return ResponseEntity.ok(quotesHandler.getAll());
    }

    /**
     * @return All available symbols
     */
    @GetMapping("/symbols")
    ResponseEntity<Set<String>> getAllSymbols() { return ResponseEntity.ok(quotesHandler.getAllSymbols()); }

    /**
     * Creates the quote
     * @param quote - the quote to be created
     * @return {@link HttpStatus#CREATED}
     * @throws {@link InvalidParameterException}
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Quote quote) {
        if (!quotesHandler.create(quote)) {
            throw new InvalidParameterException("Unable to create the given quote");
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Updates the entire quote
     * @param quote - the quote to be updated
     * @return {@link HttpStatus#NO_CONTENT}
     * @throws {@link InvalidParameterException}
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Quote quote) {
        if (!quotesHandler.update(quote)) {
            throw new InvalidParameterException("Unable to update the given quote");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Deletes the quote with the Id
     * @param symbol - the symbol to be deleted
     * @return {@link HttpStatus#NO_CONTENT}
     * @throws {@link InvalidParameterException}
     */
    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestParam("symbol") String symbol) {
        if (!quotesHandler.delete(symbol)) {
            throw new InvalidParameterException("Invalid symbol: " + symbol + " unable to delete");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
