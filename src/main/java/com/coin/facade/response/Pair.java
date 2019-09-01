package com.coin.facade.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 交易对描述
 */
@Setter
@Getter
public class Pair {
    //交易对名字
    private String pair;
    //数量精度
    private double amountScale;
    //价格精度
    private double priceScale;
}
