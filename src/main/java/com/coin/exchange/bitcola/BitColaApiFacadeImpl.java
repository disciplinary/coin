package com.coin.exchange.bitcola;

import com.coin.exchange.bitcola.domain.BitcolaDepth;
import com.coin.exchange.bitcola.domain.BitcolaPair;
import com.coin.exchange.fcoin.domain.reqs.PlaceOrderRequest;
import com.coin.facade.ApiFacade;

import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.Depth;
import com.coin.facade.response.Pair;
import com.coin.facade.response.Ticker;
import com.coin.facade.response.Trade;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
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
    public Set<Pair> pairs() {
        Set<BitcolaPair> bitcolaPair= bitColaApiFacadeGenerator.executeSync(service.pairs()).getData();
        Set<Pair> pair = new HashSet<Pair>();
        BeanUtils.copyProperties(bitcolaPair,pair);
        return pair;
    }

    @Override
    public Ticker ticker(String symbol) {
        return null;
    }

    /* @Override
   public Depth depth(DepthLevel level, String pair) {

        BitcolaDepth bitcolaDepth= bitColaApiFacadeGenerator.executeSync(service.depth(pair ,0,0)).getData();
        Depth depth = new Depth();
        BeanUtils.copyProperties(bitcolaDepth,depth);
        return depth;

    }*/

    @Override
   public Set<Trade> trades(String pair, String status, String direction, String type, int page) {
         bitColaApiFacadeGenerator.executeSync(service.getOrders(pair,status,direction,type,page)).getData();
        return  null;
    }

    @Override
    public String buy(PlaceOrder placeOrder) {

        return null;
    }

    @Override
    public String sell(PlaceOrder placeOrder) {
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
