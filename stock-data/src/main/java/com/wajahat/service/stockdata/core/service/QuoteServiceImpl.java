package com.wajahat.service.stockdata.core.service;

import com.wajahat.service.stockdata.core.domain.Quote;
import com.wajahat.service.stockdata.core.repository.QuoteRepository;
import com.wajahat.service.stockdata.core.service.api.QuoteService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = requireNonNull(quoteRepository);
    }

    @Override
    public List<Quote> findBySymbol(String symbol) {
        if (!quoteRepository.findBySymbol(symbol).isPresent()) {
            // call stock-controller
        }
        return quoteRepository.findBySymbol(symbol).get();
    }
}
