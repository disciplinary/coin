package com.coin.facade.response;

import com.coin.facade.enums.OrderDirection;
import com.coin.facade.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private long id;
    private String pair;
    private OrderDirection direction;
    private double price;
    private double amount;
    private double remain;
    private OrderStatus status;
    private String type;
    private long timestamp;
}
