package com.coin.exchange.bitcola.domain;

import com.coin.exchange.bitcola.domain.resp.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BicolaOrder {
    private long id;
    private String pair;
    private String direction;
    private String price;
    @JsonProperty("number")
    private double amount;
    private double remain;
    private OrderStatus status;
    private String type;
    private long timestamp;
}
