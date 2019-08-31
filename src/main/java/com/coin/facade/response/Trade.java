package com.coin.facade.response;

import com.coin.exchange.fcoin.domain.enums.OrderSide;
import lombok.Data;

/**
 * created by jacky. 2018/7/21 2:33 PM
 */
@Data
public class Trade {
    private String id;
    private double price;
    private double amount;
    private OrderSide side;
    private long ts;
}
