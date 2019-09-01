package com.coin.facade.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/23 3:28 PM
 */
@Data
public class Asset {
    @JsonProperty("coinCode")
    private String currency;
    private double balance;
    private double available;
    private double frozen;
    private int unitDecimal;

}
