package com.coin.service.zb.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin.utils.CalculateUtils;
import com.coin.utils.DateUtil;
import com.coin.utils.SendEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class KLine {
    private static Logger log = Logger.getLogger(KLine.class);

    private boolean isSendEmail = false;
    private String content = "";
    private String separator = System.getProperty("line.separator");
    private static Timestamp tempTimestamp = null;
    private static Map<String, Timestamp> timestampMap = new HashMap<String, Timestamp>();


    @Autowired
    private Data data;


    @Autowired
    private SendEmail sendEmail;

    /**
     * 拉升
     */
    public void pulledUp(String currency) {
        StringBuffer message = new StringBuffer("建议关注："+separator);

        //1分钟发送信息
        message.append(getSidewaysBy1Min(currency));
        //3分钟发送信息
       // message.append(getSidewaysBy3Min(currency));
        //5分钟发送信息
        message.append(getSidewaysBy5Min(currency));
        //15分钟发送信息
        message.append(getSidewaysBy15Min(currency));
        //30分钟发送信息
       // message.append(getSidewaysBy30Min(currency));
        //1小时发送信息
        message.append(getSidewaysBy1Hour(currency));
       // message.append(getSidewaysBy4Hour(currency));
        content=message.toString();
      /*  Map rest = this.get6Hoursideways(currency);
        if (rest.size() > 0) {
            isSendEmail = (Boolean) rest.get("isSendEmail");
            content = (String) rest.get("rest");
        }*/
        if (content.length()>9) {
            String sendTo[] = {"444923854@qq.com", "785020707@qq.com"};
            sendEmail.sendSimpleMail(sendTo, currency, content);
            isSendEmail = false;
        }
    }


   /* public Map pulledUp1(String currency) {
        Map rest = new HashMap();
        long time = DateUtil.getbeforeNHourTimeInMillis(1);
        JSONObject obj = data.getKline(currency, "15min", time);
        String list = obj.get("data").toString();
        JSONArray jlist = JSONObject.parseArray(list);
        //当前K线收盘值大于前一分钟的收盘值,并且前一分钟大于在前一分钟，发送邮件
        //1、获取最新的K线
        JSONArray lastOne = jlist.getJSONArray(jlist.size() - 1);
        JSONArray lastTwo = jlist.getJSONArray(jlist.size() - 2);
        JSONArray lastThree = jlist.getJSONArray(jlist.size() - 3);
        Double closeOne = lastOne.getDoubleValue(4);
        Double closeTwo = lastTwo.getDoubleValue(4);
        Double closeThree = lastThree.getDoubleValue(4);

        Double openOne = lastOne.getDoubleValue(1);



        if (closeOne.compareTo(closeTwo) > 0 && closeTwo.compareTo(closeThree) > 0 && isAmplitude(closeOne, openOne,1)) {
            isSendEmail = true;
            content = currency + "币在：" + separator + "倒数第15分钟(" + lastOne.getTimestamp(0) + ")收盘价=" + closeOne + "开盘价=" + openOne + "涨幅1%" +
                    separator + "倒数第30分钟(" + lastTwo.getTimestamp(0) + ")收盘价=" + closeTwo + separator + "倒数第45分钟(" + lastThree.getTimestamp(0) + ")收盘价=" + closeThree;
        }
        log.info(currency + "lastOne时间戳=" + lastOne.getTimestamp(0) + "收=" + lastOne.getDoubleValue(4));
        log.info(currency + "closeTwo时间戳=" + lastTwo.getTimestamp(0) + "收=" + lastTwo.getDoubleValue(4));
        log.info(currency + "closeThree时间戳=" + lastThree.getTimestamp(0) + "收=" + lastThree.getDoubleValue(4));
        //5分钟的开盘价是这个第一次开始交易的价格，收盘价是最后一次交易的价格。
        *//* for (Iterator iterator = jlist.iterator(); iterator.hasNext();) {
             JSONArray job = (JSONArray) iterator.next();
             System.out.println("时间戳="+job.getTimestamp(0));
             System.out.println("开="+job.getDoubleValue(1));
             System.out.println("高="+job.getDoubleValue(2));
             System.out.println("低="+job.getDoubleValue(3));
             System.out.println("收="+job.getDoubleValue(4));
             System.out.println("量="+job.getDoubleValue(5));
         }*//*

       return  rest;
    }*/

    /**
     * 6小时线，最近6条线的幅度在3点之内。且最后一根大于3提醒
     *
     * @param currency 币种
     * @return
     */
    /* public Map get6Hoursideways(String currency) {
        long time = DateUtil.getBeforeNHourTimeInMillis(90);
        return sideways(currency, "6hour", time, 3, 3);
    }


    /**
     * 获取1小时的振幅在5个点，
     *
     * @param currency 币种
     * @return
     */
    /*public String getSidewaysBy4Hour(String currency) {
        return this.get1KSideways(currency, "4hour", 12, 5);
    }*/
    /**
     * 获取1小时的振幅在10个点，
     *
     * @param currency 币种
     * @return
     */
    public String getSidewaysBy1Hour(String currency) {
        return this.get1KSideways(currency, "1hour", 3, 10);
    }

    /**
     * 获取30分钟的振幅在5个点，
     *
     * @param currency 币种
     * @return
     */
  /*  public String getSidewaysBy30Min(String currency) {
        return this.get1KSideways(currency, "30min", 1, 5);
    }*/

    /**
     * 获取15分钟的振幅在5个点，
     *
     * @param currency 币种
     * @return
     */
    public String getSidewaysBy15Min(String currency) {
        return this.get1KSideways(currency, "15min", 1, 5);
    }

    /**
     * 获取5分钟的振幅在5个点，
     *
     * @param currency 币种
     * @return
     */
    public String getSidewaysBy5Min(String currency) {
        return this.get1KSideways(currency, "5min", 1, 5);
    }

    /**
     * 获取三分钟的振幅在5个点，
     *
     * @param currency 币种
     * @return
     */
    /*public String getSidewaysBy3Min(String currency) {
        return this.get1KSideways(currency, "3min", 1, 5);
    }*/

    /**
     * 获取一分钟的振幅在3个点，
     *
     * @param currency 币种
     * @return
     */
    public String getSidewaysBy1Min(String currency) {
        return this.get1KSideways(currency, "1min", 1, 3);
    }

    /**
     * 获取给定货币给定周期，给定获取数据的振幅
     *
     * @param currency  币种
     * @param type      周期
     * @param n         获取几个小时前的数据
     * @param amplitude 幅度
     * @return
     */
    public String get1KSideways(String currency, String type, int n, int amplitude) {
        StringBuffer message = new StringBuffer();
        long time = DateUtil.getBeforeNHourTimeInMillis(n);
        JSONObject obj = data.getKline(currency, type, time);
        String list = obj.get("data").toString();
        JSONArray jlist = JSONObject.parseArray(list);
        //当前K线收盘值大于前一分钟的收盘值,并且前一分钟大于在前一分钟，发送邮件
        //1、获取最新的K线
        JSONArray last = jlist.getJSONArray(jlist.size() - 1);
        Timestamp timestamp = last.getTimestamp(0);//获取时间戳
        Double open = last.getDoubleValue(1);//获取开盘价
        Double close = last.getDoubleValue(4);//获取收盘价


        double percentage = CalculateUtils.amplitude(close,open );
        boolean flag = CalculateUtils.compareTo(percentage, amplitude);
        log.info(currency +":"+type+":"+percentage+"是否发送:"+flag);

        if (flag) {
            Timestamp tempTimestamp = timestampMap.get(type);
            if (tempTimestamp == null || timestamp.after(tempTimestamp)) {//第一次进来发送信息，第二次时间必须大于当前时间+1min
                message.append("在" + timestamp + "时候的" + type+ "分钟K线在的振幅是" + percentage + separator);
                String tempType="";
                if(type.contains("min")){
                    tempType= type.substring(0, type.indexOf("m"));
                }else{
                    tempType= type.substring(0, type.indexOf("h"));
                }
                tempTimestamp = DateUtil.getAfterNMinuteTimestamp(timestamp, Integer.valueOf(tempType));
                timestampMap.put(type, tempTimestamp);
            }
        }
        return message.toString();
    }

    /**
     * 获取给定货币给定周期，给定获取数据的振幅
     *
     * @param currency  币种
     * @param type      周期
     * @param n         获取几个小时前的数据
     * @param amplitude 幅度
     * @return
     */
    public String get2KSideways(String currency, String type, int n, int amplitude) {
        StringBuffer message = new StringBuffer();
        long time = DateUtil.getBeforeNHourTimeInMillis(n);
        JSONObject obj = data.getKline(currency, type, time);
        String list = obj.get("data").toString();
        JSONArray jlist = JSONObject.parseArray(list);
        //1、获取最近的1根K线
        JSONArray lastOne = jlist.getJSONArray(jlist.size() - 1);
        Timestamp timestamp = lastOne.getTimestamp(0);//获取时间戳
        Double openOne = lastOne.getDoubleValue(1);//获取开盘价
        Double closeOne = lastOne.getDoubleValue(4);//获取收盘价
        //2、获取最近的2根K线
        JSONArray lastTwo = jlist.getJSONArray(jlist.size() - 1);
       // Timestamp timestamp = lastTwo.getTimestamp(0);//获取时间戳
        Double openTwo = lastTwo.getDoubleValue(1);//获取开盘价
        Double closeTwo = lastTwo.getDoubleValue(4);//获取收盘价

        double percentage = CalculateUtils.amplitude(openOne,closeOne );
        boolean flag = CalculateUtils.compareTo(percentage, amplitude);
        log.info(currency +":"+type+":"+percentage+"是否发送:"+flag);

        if (flag) {
            Timestamp tempTimestamp = timestampMap.get(type);
            if (tempTimestamp == null || timestamp.after(tempTimestamp)) {//第一次进来发送信息，第二次时间必须大于当前时间+1min
                message.append("在" + timestamp + "时候的" + type+ "分钟K线在的振幅是" + percentage + separator);
                String tempType="";
                if(type.contains("min")){
                    tempType= type.substring(0, type.indexOf("m"));
                }else{
                    tempType= type.substring(0, type.indexOf("h"));
                }
                tempTimestamp = DateUtil.getAfterNMinuteTimestamp(timestamp, Integer.valueOf(tempType));
                timestampMap.put(type, tempTimestamp);
            }
        }
        return message.toString();
    }

    public static void main(String[] args) {
       /* Timestamp timestamp = new Timestamp(System.currentTimeMillis());//获取当前时间
        for (int i = 0; i < 2; i++) {
            if (true) {
                if (tempTimestamp == null || timestamp.after(tempTimestamp)) {
                    System.out.println("打印一次" + i);
                    // message.append("在"+date+"时候的"+type + "K线在倒数第" + i + "次的涨幅" + percentage + separator);
                    tempTimestamp = DateUtil.getAfterNMinuteTimestamp(timestamp, 1);
                }
                timestamp = DateUtil.getAfterNMinuteTimestamp(timestamp, 2);
                System.out.println(i + "tempTimestamp=" + tempTimestamp);
                System.out.println(i + "timestamp=" + timestamp);
            }
        }*/
        StringBuffer message = new StringBuffer("建议关注："+System.getProperty("line.separator"));
        System.out.println(message.toString().length());
    }
}

