package com.coin.exchange.bitcola;

import com.coin.common.ApiFacade;
import com.coin.fcoin.api.client.domain.Depth;
import com.coin.fcoin.api.client.domain.Symbol;
import com.coin.fcoin.api.client.domain.Ticker;
import com.coin.fcoin.api.client.domain.Trade;
import com.coin.fcoin.api.client.domain.enums.DepthLevel;
import com.coin.fcoin.api.client.domain.reqs.PlaceOrderRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @Classname BitColaApiFacadeImpl
 * @Description 可乐平台通用接口实现类
 * @Date 2019/8/26 11:20
 * @Created by shiyawei
 */
@Service("bitcola")
public class BitColaApiFacadeImpl implements ApiFacade {


    private BitColaApiFacadeGenerator bitColaApiFacadeGenerator =new  BitColaApiFacadeGenerator();

    private BitColaClient service = bitColaApiFacadeGenerator.createService(BitColaClient.class);

    @Override
    public Long serverTime() {
        return bitColaApiFacadeGenerator.executeSync(service.serverTime()).getData();
    }

    @Override
    public Set<Symbol> symbols() {
        return bitColaApiFacadeGenerator.executeSync(service.symbols()).getData();
    }

    @Override
    public Ticker ticker(String symbol) {
        return null;
    }

    @Override
    public Depth depth(DepthLevel level, String symbol) {
        return null;
    }

    @Override
    public Set<Trade> trades(String pair,String status,String direction,String type,int page) {
        return  bitColaApiFacadeGenerator.executeSync(service.trades(pair,status,direction,type,page)).getData();
    }

    @Override
    public String buy(String symbol, BigDecimal price, BigDecimal amount) {
        PlaceOrderRequest  PlaceOrderRequest =new PlaceOrderRequest();
        PlaceOrderRequest.setAmount("101");
        PlaceOrderRequest.setSide("buy");
        PlaceOrderRequest.setPrice("0.02");
        PlaceOrderRequest.setType("LIMIT");
        PlaceOrderRequest.setSymbol("HA_USDT");
        return null;
    }

    @Override
    public String sell(String symbol, BigDecimal price, BigDecimal amount) {
        return null;
    }

    @Override
    public String cancelOrder() {
        return null;
    }

    @Override
    public String getOrder(String id) {
        return null;
    }

    @Override
    public String getAccountInfo() {
        return null;
    }
}
