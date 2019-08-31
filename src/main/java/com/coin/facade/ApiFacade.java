package com.coin.facade;

import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.Depth;
import com.coin.facade.response.Pair;
import com.coin.facade.response.Ticker;
import com.coin.facade.response.Trade;

import java.math.BigDecimal;
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
    Ticker ticker(String symbol);

    /**
     * 获取交易所获取深度
     *
     * @return
     */
   //Depth depth(DepthLevel level, String symbol);

    /**
     * 获取交易所交易历史
     *
     * @return
     */


    /**
     * 最新成交
     *
     * @param symbol
     * @param before
     * @param limit
     * @return
     */
    Set<Trade> trades(String pair, String status, String direction, String type, int page);


    /**
     * 买入下单
     * @param placeOrder 订单信息
     * @return 订单 ID
     */

    String buy(PlaceOrder placeOrder);

    /**
     * ,卖出下单
     * @param placeOrder 订单信息
     * @return 订单 ID
     */
    String sell(PlaceOrder placeOrder);
    /**
     * 取消委托
     * @return
     */
    String cancelOrder();
    /**
     * 获取订单
     *
     * @return
     */
    String getOrder(String id);

    /**
     * 获取订单列表
     * @param symbol
     * @param side
     * @param type
     * @param price
     * @param amount
     * @return
     */
    /**
     * 获取账户信息
     */
   String getAccountInfo();
}
