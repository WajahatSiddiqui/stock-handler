package com.wajahat.service.stockdata.core.repository;

import com.wajahat.service.stockdata.core.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Quote.CompositeKey> {
    @Query("FROM Quote q " +
            "WHERE q.compositeKey.symbol = :symbol")
    Optional<List<Quote>> findBySymbol(@Param("symbol") String symbol);

    @Query("DELETE FROM Quote q " +
            "WHERE q.compositeKey.symbol = :symbol")
    void delete(@Param("symbol") String symbol);

    @Query("SELECT DISTINCT q.compositeKey.symbol FROM Quote q ")
    Optional<List<String>> findAllSymbols();
}
