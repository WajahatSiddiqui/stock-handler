package com.wajahat.service.stockviewer.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quote implements Serializable {

    private CompositeKey compositeKey;

    private Double open;
    private Double high;
    private Double low;
    private Double price;

    @JsonProperty("change_percentage")
    private Double changePercentage;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CompositeKey implements Serializable {
        private String symbol;
        private Timestamp timestamp;
    }
}
