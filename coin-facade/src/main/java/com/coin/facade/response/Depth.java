package com.coin.facade.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * created by jacky. 2018/7/21 2:28 PM
 */
@Getter
@Setter
public class Depth {
    private List<List<Double>> bids;
    private List<List<Double>> asks;
}
