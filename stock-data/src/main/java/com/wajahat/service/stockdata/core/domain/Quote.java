package com.wajahat.service.stockdata.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "quote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private Timestamp timestamp;
    private Double open;
    private Double high;
    private Double low;
    private Double price;

    @JsonProperty("change_percentage")
    @Column(name = "change_percentage")
    private Double changePercentage;
}
