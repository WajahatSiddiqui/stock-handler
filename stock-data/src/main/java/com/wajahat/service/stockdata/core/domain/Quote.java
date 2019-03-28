package com.wajahat.service.stockdata.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "quote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quote implements Serializable {

    @EmbeddedId
    private CompositeKey compositeKey;

    private Double open;
    private Double high;
    private Double low;
    private Double price;

    @JsonProperty("change_percentage")
    @Column(name = "change_percentage")
    private Double changePercentage;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CompositeKey implements Serializable {
        private String symbol;
        @Column(name = "event_time")
        private Timestamp timestamp;
    }
}
