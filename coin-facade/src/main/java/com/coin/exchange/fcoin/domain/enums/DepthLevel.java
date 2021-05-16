package com.coin.exchange.fcoin.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by jacky. 2018/7/21 2:24 PM
 * 行情深度.
 */
@Getter
@AllArgsConstructor
public enum DepthLevel {
    /**
     * 20档行情深度.
     */
    L20(20,"20档"),
    /**
     * 100档行情深度.
     */
    L100(100,"100档"),
    /**
     * 全量的行情深度, 不做时间保证和推送保证.
     */
    full(1,"");
    private int code;
    private String message;

}
