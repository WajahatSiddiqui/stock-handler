package com.wajahat.service.stockdata.rest.controller

import com.wajahat.service.stockdata.StockDataApplication
import com.wajahat.service.stockdata.core.domain.Quote
import com.wajahat.service.stockdata.core.repository.QuoteRepository
import com.wajahat.service.stockdata.core.service.api.QuoteService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import java.sql.Timestamp
import java.time.LocalDateTime

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


/**
 * QuotesControllerTest
 * @author Wajahat Siddiqui
 */

@SpringBootTest(classes = StockDataApplication.class)
@WebMvcTest
@WebAppConfiguration
@AutoConfigureMockMvc
class QuotesControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @MockBean
    QuotesController quotesController

    def "findBySymbol"() {
        given:
        quotesController.create(Quote.builder()
        .compositeKey(Quote.CompositeKey.builder()
        .symbol("MSFT").timestamp(Timestamp.valueOf(LocalDateTime.now())).build())
                .open(100.8)
                .low(100.1)
                .high(100.9)
                .price(100.4)
                .changePercentage(000.1)
                .build())
        when:
        def all_quotes = mockMvc.perform(get("/quotes/all"))
                            .andDo(println())
        then:
        all_quotes.andExpect(status().isOk())
    }

    @TestConfiguration
    static class MockConfig {
        def factory = new DetachedMockFactory()
        @Bean
        QuotesController quotesController() {
            factory.Mock(QuotesController)
        }
    }
}