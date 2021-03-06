package com.coin.exchange.bitcola.domain.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * created by jacky. 2018/7/21 11:16 AM
 */
@Getter
@Setter
public class RespBody<T> {
    private String status;
    private T data;
    private String message;
    public String toErrorString() {
        String format = "errMsg:%s.";
        return String.format(format, message);
    }


}
