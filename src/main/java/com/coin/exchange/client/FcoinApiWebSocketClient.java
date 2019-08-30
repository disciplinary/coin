package com.coin.exchange.client;

import com.coin.exchange.client.domain.enums.DepthLevel;
import com.coin.exchange.client.domain.enums.Resolution;
import com.coin.exchange.client.domain.event.CandleResp;
import com.coin.exchange.client.domain.event.DepthResp;
import com.coin.exchange.client.domain.event.TickerResp;
import com.coin.exchange.client.domain.event.TradeResp;
import com.fcoin.api.client.domain.resp.ApiCallback;

import java.io.Closeable;

/**
 * created by jacky. 2018/7/24 3:52 PM
 */
public interface FcoinApiWebSocketClient {
    Closeable onTicker(String symbol, ApiCallback<TickerResp> callback);

    Closeable onDepth(DepthLevel level, String symbol, ApiCallback<DepthResp> callback);

    Closeable onCandle(Resolution resolution, String symbol, ApiCallback<CandleResp> callback);

    Closeable onTrade(String symbol, ApiCallback<TradeResp> callback);



}
