package com.coin.exchange.bitcola.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * created by jacky. 2018/7/21 2:28 PM
 */
@Getter
@Setter
public class BitcolaDepth {
    private List<List<Double>> bids;
    private List<List<Double>> asks;
}
