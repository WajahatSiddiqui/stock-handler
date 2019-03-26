package com.wajahat.service.stockdata.core.repository;

import com.wajahat.service.stockdata.core.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Optional<List<Quote>> findBySymbol(String symbol);
}
