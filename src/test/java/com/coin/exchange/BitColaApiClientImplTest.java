package com.coin.exchange;

import com.alibaba.fastjson.JSON;
import com.coin.Link;
import com.coin.exchange.bitcola.BitColaApiFacadeImpl;
import com.coin.facade.ApiFacade;

import com.coin.facade.enums.OrderDirection;
import com.coin.facade.request.PlaceOrder;
import com.coin.facade.response.Order;
import com.coin.facade.response.Pair;
import com.coin.facade.response.Trade;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @Classname BitColaApiClientImplTest
 * @Description TODO
 * @Date 2019/8/26 14:45
 * @Created by shiyawei
 */
@Slf4j
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration*/
public class BitColaApiClientImplTest {
    @Autowired
    private ApiFacade client;

    @Before
    public void config() throws IOException {
        /*InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
        Properties props = new Properties();
        props.load(is);
        apiKey = props.getProperty("apiKey");
        apiSecret = props.getProperty("apiSecret");*/
        client = new BitColaApiFacadeImpl();
    }

    /**
     * 获取服务器时间
     */
    @Test
    public void serverTime() {
        long timestamp = client.serverTime();
        log.info(String.valueOf(timestamp));
        assert timestamp > 0;
    }

    /**
     * 查询支持的交易对
     */
    @Test
    public void pairs() {
        Set<Pair> pairs = client.pairs();
        for(Pair pair  :pairs  ){
            log.info(JSON.toJSONString(pair));
        }
    }
    @Test
    public void trades() {
        List<Trade> TradeList = client.trades("HA_USDT",1);
        for(Trade trade  :TradeList  ){
            log.info(JSON.toJSONString(trade));
        }
    }

    @Test
    public void buy() {
        PlaceOrder placeOrder = new PlaceOrder ();
        placeOrder.setPair("HA_USDT");
        placeOrder.setAmount(new BigDecimal("10"));
        placeOrder.setPrice(new BigDecimal("0.09194"));
        placeOrder.setDirection(OrderDirection.buy);
        String a = client.placeOrder(placeOrder);
        log.info(JSON.toJSONString(a));
    }

    @Test
    public void sell() {
        PlaceOrder placeOrder = new PlaceOrder ();
        placeOrder.setPair("HA_USDT");
        placeOrder.setAmount(new BigDecimal(3));
        placeOrder.setPrice(new BigDecimal(0.092));
        placeOrder.setDirection(OrderDirection.sell);
        String a = client.placeOrder(placeOrder);
        log.info(JSON.toJSONString(a));
    }


    @Test
    public void getOrder() {
        Order order = client.getOrder("1168111273498296320");
        log.info(JSON.toJSONString(order));
    }

    @Test
    public void cancelOrder() {
         String a =client.cancelOrder("1168111273498296320");
        log.info(JSON.toJSONString(a));
    }
    @Test
    public void getOrders() {
        List<Order> orderList = client.getOrders("HA_USDT","","","",1);
        for(Order order  :orderList  ){
            log.info(JSON.toJSONString(order));
        }
    }


}

