package com.coin.exchange.bitcola.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 交易对描述
 */
@Setter
@Getter
public class Symbol {
    //交易对名字
    @JsonProperty("pair")
    private String name;
    //数量精度
    @JsonProperty("amountScale")
    private BigDecimal priceDecimal;
    //数量精度
    @JsonProperty("priceScale")
    private BigDecimal amountDecimal;
}
