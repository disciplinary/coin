package com.coin.exchange;

import com.alibaba.fastjson.JSON;
import com.coin.exchange.bitcola.BitColaApiFacadeImpl;
import com.coin.exchange.bitcola.domain.Symbol;
import com.coin.exchange.bitcola.domain.Trade;
import com.coin.facade.ApiFacade;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @Classname BitColaApiClientImplTest
 * @Description TODO
 * @Date 2019/8/26 14:45
 * @Created by shiyawei
 */
@Slf4j
public class BitColaApiClientImplTest {
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


    @Test
    public void symbols() {
        Set<Symbol> symbolsList = client.symbols();
        for(Symbol symbol  :symbolsList  ){
            log.info(JSON.toJSONString(symbol));
        }
    }
    @Test
    public void trades() {
        Set<Trade> symbols = client.trades("HA_USDT",null,null,null,2);
        log.info(JSON.toJSONString(symbols));
    }

    @Test
    public void buy() {
      String a = client.buy("HA_USDT",new BigDecimal(20),new BigDecimal(20));
        log.info(JSON.toJSONString(a));
    }




}

