package com.coin.exchange.bitcola;

import com.coin.exchange.Consts;
import com.coin.exchange.bitcola.domain.*;
import com.coin.exchange.bitcola.domain.resp.RespBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.math.BigDecimal;
import java.util.List;
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
     * 获取支持的交易对
     * @return
     */
    @GET("api/market/config")
    Call<RespBody<Set<BitcolaPair>>> pairs();

    /**
     * 获取深度
     * @param pair 交易对
     * @param size
     * @param merge
     * @return
     */

    Call<RespBody<BitcolaDepth>> depth(String pair, int size, int merge);

    /**
     * 查询历史交易记录
     * @param pair 必填
     * @param size  Default 20，Max 100
     * @return
     */
    @GET("/api/market/trades")
    Call<RespBody<BitcolaTrade>>  getTrades(String pair, int size);


    /**
     * 获取账号信息
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/getAccountInfo")
    Call<RespBody<List<BitcolaAsset>>>  getAccount();

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
    Call<RespBody<String>>  placeOrder(String pair, String type, String direction, BigDecimal price, BigDecimal amount);

    /**
     * 根据id撤销订单
     * @param id
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/cancelOrder")
    Call<RespBody<String>> cancelOrder(String id);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Headers(Consts.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/trade/getOrder")
    Call<RespBody<Set<BicolaOrder>>> getOrder(String id);

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
    Call<RespBody<List<BicolaOrder>>> getOrders(@Query("pair")String symbol, @Query("status")String status, @Query("direction")String direction, @Query("type")String type, @Query("page")  Integer page);

}
