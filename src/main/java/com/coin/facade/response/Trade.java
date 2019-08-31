package com.coin.facade.response;

import com.coin.exchange.bitcola.domain.enums.OrderDirection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * created by jacky. 2018/7/21 2:33 PM
 */
@Data
public class Trade {
    private String id;
    private double price;
    @JsonProperty("number")
    private double amount;
    private OrderDirection direction;
    private long timestamp;
}