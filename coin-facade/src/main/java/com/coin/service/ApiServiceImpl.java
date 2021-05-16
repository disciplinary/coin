package com.coin.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin.facade.ApiFacade;
import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ApiServiceImpl  implements ApiService{
    @Autowired
    private ApiFacade client;

    @Override
    public Long serverTime() {
        return null;
    }

    @Override
    public Set<Pair> pairs() {
        return null;
    }

    @Override
    public Ticker ticker(String pair) {
        return null;
    }

    @Override
    public Depth depth(String pair) {
        return null;
    }

    @Override
    public List<Trade> trades(String pair, int page) {
        return null;
    }

    @Override
    public String placeOrder(PlaceOrder placeOrder) {
        return null;
    }

    @Override
    public String cancelOrder(String id) {
        return null;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public List<Order> getOrders(String pair, String status, String direction, String type, Integer page) {
        return null;
    }

    @Override
    public List<Asset> getAccountInfo() {
        return null;
    }

    public  void batchCancelOrder(String pair,String direction){
        Boolean flag=true;
        int num=0;
        while (flag){
            List<Order> orders = client.getOrders(pair, "PENDING", direction, "LIMIT", 1);
            //先将string串转为json对象
            JSONObject js = JSONArray.parseObject(orders.toString());
            if (1000 == (int) js.get("status")) {
                JSONArray dataList = (JSONArray) js.get("data");
                if(dataList.size()==0){
                    flag =false;
                }
                for (int i = 0; i < dataList.size(); i++) {
                    JSONObject object = (JSONObject) dataList.get(i);
                    if ("PENDING".equals(object.get("status"))) {
                        client.cancelOrder(object.get("id").toString());
                    }
                }
            }if(num>5){
               // throw new ApiException("撤销订单异常");
            }
            num++;
        }

    }

}
