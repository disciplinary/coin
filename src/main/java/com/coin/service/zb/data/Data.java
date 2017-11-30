package com.coin.service.zb.data;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class Data {

    public static String API_DOMAIN = "http://api.zb.com";

    private static Logger log = Logger.getLogger(Data.class);



    /**
     *
     * @param urlAll
     *            :请求接口
     * @param charset
     *            :字符编码
     * @return 返回json结果
     */
    public String get(String urlAll, String charset) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器
        try {
            URL url = new URL(urlAll);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.setRequestProperty("User-agent", userAgent);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, charset));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 测试获取行情
     */
//	@Test
    public void getTicker( String currency) {
        try {
             currency = "bcc_usdt";
            // 请求地址
            String url = API_DOMAIN + "/data/v1/ticker?market=" + currency;
            log.info(currency + "-testTicker url: " + url);
            // 请求测试
            String callback = get(url, "UTF-8");
            log.info(currency + "-testTicker 结果: " + callback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 测试获取深度
     */
//	@Test
    public void getDepth(String currency) {
        try {
             currency = "ltc_btc";
            String merge = "0.1";
            // 请求地址
            String url = API_DOMAIN + "/data/v1/depth?market=" + currency;
            // String url = API_DOMAIN+"/data/v1/depth?currency=" + currency +
            // "&size=3&merge=" + merge;
            // String url = API_DOMAIN+"/data/v1/depth?currency=" + currency +
            // "&size=3";
            log.info(currency + "-testDepth url: " + url);
            // 请求测试
            String callback = get(url, "UTF-8");
            log.info(currency + "-testDepth 结果: " + callback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 测试获取最近交易记录
     */
//	@Test
    public void getTrades(String  currency) {
        try {
             currency = "etc_btc";
            // 请求地址
            String url = API_DOMAIN + "/data/v1/trades?market=" + currency;
            log.info(currency + "-testTrades url: " + url);
            // 请求测试
            String callback = get(url, "UTF-8");
            log.info(currency + "-testTrades 结果: " + callback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取K线数据
     */
//	@Test
    public JSONObject getKline(String  currency ,String type ,Long since  ) {
        JSONObject json=null;
        try {
            Thread.sleep(1000);
            String url = API_DOMAIN + "/data/v1/kline?market=" + currency + "&type="+type+"&size=1000&since="+since;
            //log.info(currency + "-testKline url: " + url);
            String  callback = get(url, "UTF-8");
             json = JSONObject.parseObject(callback);
            //log.info(currency + "-testKline 结果: " + json.toJSONString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
