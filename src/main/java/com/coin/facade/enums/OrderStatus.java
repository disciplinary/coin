package com.coin.facade.enums;

import com.coin.exchange.fcoin.domain.enums.ErrorCode;
import com.coin.exchange.fcoin.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    FULL_COMPLETED("FULL_COMPLETED","已成交"),

    PENDING("PENDING","交易中"),

    FULL_CANCELLED("FULL_CANCELLED","已取消"),

    PARTIAL_COMPLETED("PARTIAL_COMPLETED","部分成交"),

    PARTIAL_CANCELLED("PARTIAL_CANCELLED","部分撤销"),

    UNKNOWN_TYPE("UNKNOWN_TYPE","未知类型")
    ;
    private String  code;
    private String name;
    // 普通方法
    public static OrderStatus getName(String code) {
        for (OrderStatus c : OrderStatus.values()) {
            if (c.code.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return UNKNOWN_TYPE;
    }

}
