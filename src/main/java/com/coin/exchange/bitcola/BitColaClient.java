package com.coin.exchange.bitcola;

import com.coin.exchange.bitcola.domain.Depth;
import com.coin.fcoin.api.client.constant.Consts;
import com.coin.fcoin.api.client.domain.Symbol;
import com.coin.fcoin.api.client.domain.Trade;
import com.coin.fcoin.api.client.domain.resp.RespBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @Classname BitColaApiClient
 * @Description 可乐平台支持的接口定义
 * @Date 2019/8/26 14:06
 * @Created by shiyawei
 */
public interface BitColaClient {
    //一般请求，通过注释GET表明为GET方法
    //https://api.github.com/users/list
    //定义返回的方法，返回的响应体使用了ResponseBody，也可以返回一个对入Gson解析

    /**
     * 获取服务器时间
     * @return
     */
    @GET("api/market/timestamp")
    Call<RespBody<Long>> serverTime();
    /**
     * 获取交易对说明
     * @return
     */
    @GET("api/market/config")
    Call<RespBody<Set<Symbol>>> symbols();

    /**
     * 获取深度
     * @param level
     * @param pair
     * @return
     */

    Call<RespBody<Depth>> depth(@Path("level") String level, @Path("pair") String pair);

    /**
     * 查询历史交易记录
     * @return
     */
    @GET("/api/market/trades")
    Call<RespBody<Long>>  getTrades( @Path("pair") String pair);


    /**
     * 获取账号信息
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/getAccountInfo")
    Call<RespBody<Long>>  getAccount();

    /**
     * 下单
     * @param pair
     * @param type
     * @param direction
     * @param price
     * @param amount
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/order")
    Call<RespBody<Long>>  placeOrder(String pair, String type, String direction, BigDecimal price, BigDecimal amount);

    /**
     * 根据id撤销订单
     * @param id
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/cancelOrder")
    Call<RespBody<Long>> cancelOrder(@Query("id")String id);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/getOrder")
    Call<RespBody<Set<Trade>>> getOrder(@Query("id")String id);

    /**
     * 查询订单
     * @param symbol
     * @param status
     * @param direction
     * @param type
     * @param page
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("api/trade/getOrders")
    Call<RespBody<Set<Trade>>> getOrders(@Query("pair")String symbol,@Query("status")String status,@Query("direction")String direction,@Query("type")String type,@Query("page")  Integer page);

}
