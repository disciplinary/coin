package com.coin.exchange.bitcola;

import com.coin.exchange.bitcola.domain.Depth;
import com.coin.exchange.bitcola.domain.Symbol;
import com.coin.exchange.bitcola.domain.Ticker;
import com.coin.exchange.bitcola.domain.Trade;
import com.coin.exchange.fcoin.domain.reqs.PlaceOrderRequest;
import com.coin.facade.ApiFacade;

import com.coin.facade.request.DepthLevel;
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
    public Set<Trade> trades(String pair, String status, String direction, String type, int page) {
        // bitColaApiFacadeGenerator.executeSync(service.getOrders(pair,status,direction,type,page)).getData()
        return  null;
    }

    @Override
    public String buy(String symbol, BigDecimal price, BigDecimal amount) {
        PlaceOrderRequest PlaceOrderRequest =new PlaceOrderRequest();
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
