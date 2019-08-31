package com.coin.exchange.bitcola.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/23 3:28 PM
 */
@Data
public class BitcolaAsset {
    @JsonProperty("coinCode")
    private String currency;
    private BigDecimal balance;
    private BigDecimal available;
    private BigDecimal frozen;
    private int unitDecimal;

}
