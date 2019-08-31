package com.coin.scheduler;

import com.coin.exchange.zb.data.KLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling  //打开quartz定时器总开关
public class MainScheduler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KLine kLine;
    @Scheduled(cron="0/10 * * * * ?") //每b秒钟执行一次
    public void pulledUp () throws InterruptedException {

        String[] arr = new String[]{"btc_usdt", "ltc_usdt", "eth_usdt", "etc_usdt", "bts_usdt", "bcc_usdt", "qtum_usdt", "eos_usdt", "hsr_usdt"};

        //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        for (int i = 0; i <arr.length ; i++) {
            kLine.pulledUp(arr[i]);
        }



    }

/*    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void statusCheck() {
        //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        logger.info("每分钟执行一次。开始……");
        //statusTask.healthCheck();
        logger.info("每分钟执行一次。结束。");
    }

    @Scheduled(fixedRate=20000)
    public void testTasks() {
        logger.info("每20秒执行一次。开始……");
        //statusTask.healthCheck();
        logger.info("每20秒执行一次。结束。");
    }*/
}