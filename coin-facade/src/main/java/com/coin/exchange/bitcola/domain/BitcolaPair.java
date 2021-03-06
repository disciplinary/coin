package com.coin.exchange.bitcola.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 交易对描述
 */
@Setter
@Getter
public class BitcolaPair {
    //交易对名字
    private String pair;
    //数量精度
    private double amountScale;
    //价格精度
    private double priceScale;

}
