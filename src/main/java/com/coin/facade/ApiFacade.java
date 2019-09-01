package com.coin.facade;

import com.coin.exchange.bitcola.domain.BitcolaTrade;
import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.*;

import java.util.List;
import java.util.Set;

/**
 * @Classname ApiRestClient
 * @Description 通用交易接口定义，交易所根据具体提供的接口实现，没有实现的功能返回错误信息
 * @Date 2019/8/26 10:32
 * @Created by shiyawei
 */
public interface ApiFacade {
    /**
     * 服务器时间
     *
     * @return  服务器时间戳
     */
    Long serverTime();

    /**
     * 获取支持的交易对
     * @return
     */
    Set<Pair> pairs();
    /**
     * 获取市场当前行情
     *
     * @return
     */
    Ticker ticker(String pair);

    /**
     * 获取交易所获取深度
     *
     * @return
     */
   Depth depth(String pair);

    /**
     * 获取交易所交易历史
     *
     * @return
     */


    /**
     * 最新成交记录
     *
     * @param pair
     * @param page
     * @return
     */
    public List<Trade> trades(String pair, int page);

    /**
     * ,下单
     * @param placeOrder 订单信息
     * @return 订单 ID
     */
    String placeOrder(PlaceOrder placeOrder);
    /**
     * 取消委托
     * @return
     */
    String cancelOrder(String id);
    /**
     * 获取订单
     *
     * @return
     */
    Order getOrder(String id);

    /**
     * 获取订单列表
     * @param pair
     * @param status
     * @param type
     * @param direction
     * @param type
     * @param page
     * @return
     */

    public List<Order> getOrders(String pair, String status,String direction, String type, Integer page);


    /**
     * 获取账户信息
     */
    public List<Asset> getAccountInfo();
}
