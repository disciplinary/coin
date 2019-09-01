package com.coin.exchange.bitcola.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BicolaOrder {
    private long id;
    private String pair;
    private String direction;
    private BigDecimal price;
    @JsonProperty("number")
    private double amount;
    private BigDecimal remain;
    private String status;
    private String type;
    private BigDecimal timestamp;
}
