package com.wajahat.service.stockcontroller.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ${CLASS_NAME}
 *
 * @author Wajahat Siddiqui
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlphaVantageQuote implements Serializable {
    @JsonProperty("Global Quote")
    private GlobalQuote globalQuote;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GlobalQuote implements Serializable{
        @JsonProperty("01. symbol")
        private String symbol;
        @JsonProperty("02. open")
        private Double open;
        @JsonProperty("03. high")
        private Double high;
        @JsonProperty("04. low")
        private Double low;
        @JsonProperty("05. price")
        private Double price;
        @JsonProperty("06. volume")
        private Long volume;
        @JsonProperty("07. latest trading day")
        private String trading_day;
        @JsonProperty("08. previous close")
        private Double previous_close;
        @JsonProperty("09. change")
        private Double change;
        @JsonProperty("10. change percent")
        private String change_percent;
    }
}
