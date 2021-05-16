package com.coin.exchange.bitcola;

import com.coin.exchange.Convers;
import com.coin.exchange.bitcola.domain.*;
import com.coin.facade.ApiFacade;

import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.*;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.Query;

import java.util.List;
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
        return Convers.copySet(bitcolaPair,Pair.class);
    }

    @Override
    public Ticker ticker(String symbol) {
        return null;
    }

     @Override
   public Depth depth(String pair) {
        BitcolaDepth bitcolaDepth= bitColaApiFacadeGenerator.executeSync(service.depth(pair ,"100","")).getData();
         return  Convers.convert(bitcolaDepth,Depth.class);
    }

    @Override
   public List<Trade> trades(String pair, int page) {
        List<BitcolaTrade>  bitcolaTradeList= bitColaApiFacadeGenerator.executeSync(service.getTrades(pair,String.valueOf(page))).getData();
        return Convers.copyList(bitcolaTradeList,Trade.class);
    }

    @Override
    public String placeOrder(PlaceOrder placeOrder) {
        String  price= placeOrder.getPrice().stripTrailingZeros().toPlainString();
        String amount=placeOrder.getAmount().stripTrailingZeros().toPlainString();
        return bitColaApiFacadeGenerator.executeSync(service.placeOrder(placeOrder.getPair(),placeOrder.getType(), placeOrder.getDirection().name(),price,amount)).getData();

    }

    @Override
    public String cancelOrder(String id) {
        return bitColaApiFacadeGenerator.executeSync(service.cancelOrder(id)).getData();
    }

    @Override
    public Order getOrder(String id) {
        BicolaOrder bicolaOrder= bitColaApiFacadeGenerator.executeSync(service.getOrder(id)).getData();
        return Convers.convert(bicolaOrder,Order.class);
    }

    @Override
    public List<Order> getOrders(String pair, String status,String direction, String type, Integer page) {
        List<BicolaOrder> bicolaOrderList= bitColaApiFacadeGenerator.executeSync(service.getOrders(pair,status,direction,type,String.valueOf(page))).getData();
        return Convers.copyList(bicolaOrderList,Order.class);
    }

    @Override
    public List<Asset> getAccountInfo() {
        List<BitcolaAsset> assetList= bitColaApiFacadeGenerator.executeSync(service.getAccount()).getData();
        return Convers.copyList(assetList,Asset.class);
    }
}
