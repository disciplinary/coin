package com.coin.facade.response;

import com.coin.facade.enums.OrderDirection;
import lombok.Data;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/21 2:33 PM
 */
@Data
public class Trade {
    private String id;
    private double price;
    private double amount;
    private OrderDirection direction;
    private long timestamp;
}
