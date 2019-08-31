package com.coin.facade.response;

import com.coin.exchange.bitcola.domain.enums.OrderDirection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private long id;
    private String pair;
    private OrderDirection direction;
    private BigDecimal price;
    @JsonProperty("number")
    private double amount;
    private BigDecimal remain;
    private String status;
    private String type;
    private BigDecimal timestamp;
}
