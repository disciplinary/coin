package com.coin.exchange.fcoin.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * created by jacky. 2018/7/21 3:56 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class ApiException extends RuntimeException {
    private String errCode;
    private String errMsg;


    public ApiException(int errCode, String message) {
        this(String.valueOf(errCode), message);
    }

    public ApiException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
        errMsg = message;
    }


    public ApiException(String message) {
        super(message);
        errMsg = message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    protected ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
