package com.coin.exchange.fcoin.domain.resp;

import com.coin.exchange.fcoin.domain.Trade;
import lombok.Getter;
import lombok.Setter;

/**
 * created by jacky. 2018/7/21 2:40 PM
 */
@Getter
@Setter
public class TradeResp {
    private RespTick<Trade> tick;
}
