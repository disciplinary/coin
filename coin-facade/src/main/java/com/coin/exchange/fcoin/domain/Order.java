package com.coin.exchange.fcoin.domain;

import com.coin.exchange.fcoin.domain.enums.OrderState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.coin.exchange.fcoin.domain.enums.OrderSide;
import com.coin.exchange.fcoin.domain.enums.OrderSource;
import com.coin.exchange.fcoin.domain.enums.OrderType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/21 3:20 PM
 */
@Getter
@Setter
public class Order {
    private String id;
    private String symbol;
    private OrderSide side;
    private OrderType type;
    private BigDecimal price;
    private BigDecimal amount;
    private OrderState state;
    @JsonProperty("executed_value")
    private BigDecimal executedValue;
    @JsonProperty(value = "filled_amount")
    private BigDecimal filledAmount;
    @JsonProperty(value = "fill_fees")
    private String fillFees;
    @JsonProperty(value = "created_at")
    private Long createdAt;
    private OrderSource source;



    private String exchange;




}
