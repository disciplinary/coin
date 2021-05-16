package com.coin.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String PATTERN_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    private static Calendar calendar  = Calendar.getInstance();
        /**
         * 得到年
         *
         * @return
         */
        public static int getYear() {
            return calendar.get(Calendar.YEAR);
        }

        /**
         * 得到月份
         * 注意，这里的月份依然是从0开始的
         *
         * @return
         */
        public static int getMonth() {
            return calendar.get(Calendar.MONTH);
        }

        /**
         * 得到日期

         * @return
         */
        public static int getDate(Calendar c) {
                return calendar.get(Calendar.DATE);
        }

        /**
         * 得到星期
         * @return
         */
        public static int getDay() {
                return calendar.get(Calendar.DAY_OF_WEEK);
        }

        /**
         * 得到小时
         * @return
         */
        public static int getHour() {
                return calendar.get(Calendar.HOUR);
        }

        /**
         * 得到分钟
         * @return
         */
        public static int getMinute() {
                return calendar.get(Calendar.MINUTE);
        }

        /**
         * 得到秒
         * @return
         */
        public static int getSecond() {
                return calendar.get(Calendar.SECOND);
        }

        /**
         * 得到当前时间时间戳
         */

        public static long getTimeInMillis() {
            return calendar.getTimeInMillis();
        }

    /**
     * 得到当前时间n分钟前的时间戳
     */

    public static long getBeforeNMinuteTimeInMillis(int n) {
        //偏移量，给定n分钟的毫秒数
        long offset = n  * 60 * 1000;
        return calendar.getTimeInMillis()-offset;
    }

    /**
     * 得到给定时间n分钟前的Timestamp
     */

    public static Timestamp getBeforeNMinuteTimestamp(Timestamp timestamp ,int n) {
        //偏移量，给定n分钟的毫秒数
        long offset = n  * 60 * 1000;
        return  new Timestamp(timestamp.getTime()-offset);
    }
    /**
     * 得到指定时间后n分钟前的Timestamp
     */

    public static Timestamp getAfterNMinuteTimestamp(Timestamp timestamp ,int n) {
        //偏移量，给定n分钟的毫秒数
        long offset = n  * 60 * 1000;
        return  new Timestamp(timestamp.getTime()+offset);
    }
    /**
     * 得到当前时间n小时前的时间戳
     */

    public static long getBeforeNHourTimeInMillis(int n) {
        //偏移量，给定n小时的毫秒数
        long offset = n * 60 * 60 * 1000;
        return calendar.getTimeInMillis()-offset;
    }
    /**
         * 得到当前时间前n天的Calendar
         * @param n
         * @return
         */
        public static Calendar getBeforeNDaysTimeInMillis(int n) {
            //偏移量，给定n天的毫秒数
            long offset = n * 24 * 60 * 60 * 1000;
            calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
            return calendar;
        }

        /**
         * 得到当前时间后n天的Calendar
         * @param n
         * @return
         */
        public static Calendar afterNDays(int n) {
            //偏移量，给定n天的毫秒数
            long offset = n * 24 * 60 * 60 * 1000;
            Calendar calendar = null;
            calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
            return calendar;
        }


        /**
         * 时间戳转换成字符串的日期（yyyy-MM-dd HH:mm:ss）
         * @return
         */
        public static String timeInMillis2String(long timeInMillis) {
            SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_yyyy_MM_dd_HH_mm_ss);
            return sdf.format(timeInMillis);
        }

        /**
         * Date类型转换到Calendar类型
         *
         * @param d
         * @return
         */
        public static Calendar Date2Calendar(Date d) {
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c;
        }

        /**
         * Calendar类型转换到Date类型
         *
         * @param c
         * @return
         */
        public static Date Calendar2Date(Calendar c) {
            return c.getTime();
        }

        /**
         * Date类型转换到Timestamp类型
         *
         * @param d
         * @return
         */
        public static Timestamp Date2Timestamp(Date d) {
            return new Timestamp(d.getTime());
        }

        /**
         * Calendar类型转换到Timestamp类型
         *
         * @param c
         * @return
         */
        public static Timestamp Calendar2Timestamp(Calendar c) {
            return new Timestamp(c.getTimeInMillis());
        }

        /**
         * Timestamp类型转换到Calendar类型
         *
         * @param ts
         * @return
         */
        public static Calendar Timestamp2Calendar(Timestamp ts) {
            Calendar c = Calendar.getInstance();
            c.setTime(ts);
            return c;
        }

        /**
         * 得到当前时间的字符串表示
         * 格式2010-02-02 12:12:12
         *
         * @return
         */
        public static String getTimeString() {
            return timeInMillis2String(getTimeInMillis());
        }

        /**
         * 标准日期格式字符串解析成Calendar对象
         *
         * @param s
         * @return
         */
        public static Calendar pars2Calender(String s) {
            Timestamp ts = Timestamp.valueOf(s);
            return Timestamp2Calendar(ts);
        }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       System.out.println( DateUtil.timeInMillis2String(getBeforeNHourTimeInMillis(1)));
    }
}

