package com.wajahat.service.stockdata.core.service;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.core.repository.QuoteRepository;
import com.wajahat.service.stockdata.core.service.api.QuoteService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = requireNonNull(quoteRepository);
    }

    @Override
    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    @Override
    public List<Quote> findBySymbol(String symbol) {
        if (!quoteRepository.findBySymbol(symbol).isPresent()) {
            // call stock-controller
        }
        return quoteRepository.findBySymbol(symbol).get();
    }

    @Override
    public boolean create(Quote quote) {
        return quoteRepository.save(quote) != null;
    }

    @Override
    public boolean update(Quote quote) {
        return quoteRepository.existsById(quote.getCompositeKey()) && quoteRepository.save(quote) != null;
    }

    @Override
    public boolean delete(String symbol) {
        if (!quoteRepository.findBySymbol(symbol).isPresent())
            return false;
        quoteRepository.delete(symbol);
        return !quoteRepository.findBySymbol(symbol).isPresent();
    }

    @Override
    public Set<String> findAllSymbols() {
        if (!quoteRepository.findAllSymbols().isPresent())
            return Collections.emptySet();
        return new HashSet<>(quoteRepository.findAllSymbols().get());
    }
}
