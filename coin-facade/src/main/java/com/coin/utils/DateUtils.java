package com.coin.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       // System.out.println( DateUtils.timeInMillis2String(getBeforeNHourTimeInMillis(1)));
        compare();
    }
    public static void compute() {
        // TemporalAdjusters 的静态方法
        LocalDate today = LocalDate.now();
        // 获取今年的第一天
        LocalDate date = today.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("今年的第一天是：" + date);
        // Duration 计算
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now().plusMonths(1);
        Duration duration = Duration.between(from, to);

        // 区间统计换算
        // 总天数
        long days = duration.toDays();
        System.out.println("相隔" + days + "天");
        // 小时数
        long hours = duration.toHours();
        System.out.println("相隔" + hours + "小时");
        // 分钟数
        long minutes = duration.toMinutes();
        System.out.println("相隔" + minutes + "分钟");
    }
    public static void compare() {
        LocalDate thisDay = LocalDate.of(2008, 8, 8);
        LocalDate otherDay = LocalDate.of(2018, 8, 8);

        // 晚于
        boolean isAfter = thisDay.isAfter(otherDay);
        System.out.println(isAfter);

        // 早于
        boolean isBefore = thisDay.isBefore(otherDay);
        System.out.println(isBefore);
    }

    public static void duration() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now().plusDays(1);
        // 通过between()方法创建
        Duration duration = Duration.between(from, to);
        // 通过of()方法创建,该方法参数为时间段长度和时间单位。
        // 7天
        Duration duration1 = Duration.of(7, ChronoUnit.DAYS);
        // 60秒
        Duration duration2 = Duration.of(60, ChronoUnit.SECONDS);
    }

    public static void localDateTime() {
        // 当前日期和时间
        LocalDateTime today = LocalDateTime.now();
        System.out.println("现在是：" + today);

        // 创建指定日期和时间
        LocalDateTime anotherDay = LocalDateTime.of(2008, Month.AUGUST, 8, 8, 8, 8);
        System.out.println("创建的指定时间是：" + anotherDay);

        // 拼接日期和时间
        // 使用当前日期，指定时间生成的 LocalDateTime
        LocalDateTime thisTime = LocalTime.now().atDate(LocalDate.of(2008, 8, 8));
        System.out.println("拼接的日期是：" + thisTime);
        // 使用当前日期，指定时间生成的 LocalDateTime
        LocalDateTime thisDay = LocalDate.now().atTime(LocalTime.of(12, 24, 12));
        System.out.println("拼接的日期是：" + thisDay);
        // 指定日期和时间生成 LocalDateTime
        LocalDateTime thisDayAndTime = LocalDateTime.of(LocalDate.of(2008, 8, 8), LocalTime.of(12, 24, 12));
        System.out.println("拼接的日期是：" + thisDayAndTime);

        // 获取LocalDate
        LocalDate todayDate = today.toLocalDate();
        System.out.println("今天日期是：" + todayDate);

        // 获取LocalTime
        LocalTime todayTime = today.toLocalTime();
        System.out.println("现在时间是：" + todayTime);
    }
    public static void localTime() {
        // 获取当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("当前时间：" + nowTime);

        //获取小时的两种方式
        int hour = nowTime.getHour();
        int thisHour = nowTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("当前时：" + hour);
        System.out.println("当前时：" + thisHour);


        //获取分的两种方式
        int minute = nowTime.getMinute();
        int thisMinute = nowTime.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println("当前分：" + minute);
        System.out.println("当前分：" + thisMinute);

        //获取秒的两种方式
        int second = nowTime.getSecond();
        int thisSecond = nowTime.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println("当前秒：" + second);
        System.out.println("当前秒：" + thisSecond);

        // 构造指定时间(最多可到纳秒)
        LocalTime anotherTime = LocalTime.of(20, 8, 8);
        System.out.println("构造指定时间：" + anotherTime);
    }
    public static void localDate() {
        //获取当前年月日
        LocalDate today = LocalDate.now();
        System.out.println("当前年月日：" + today);

        // 获取年的两种方式
        int thisYear = today.getYear();
        int thisYearAnother = today.get(ChronoField.YEAR);
        System.out.println("今年是" + thisYear + "年");
        System.out.println("今年是" + thisYearAnother + "年");

        // 获取月
        Month thisMonth = today.getMonth();
        System.out.println(thisMonth.toString());
        // 这是今年的第几个月(两种写法)
        int monthOfYear = today.getMonthValue();
        // int monthOfYear = today.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("这个月是今年的第" + monthOfYear + "个月");
        // 月份的天数
        int length = today.lengthOfMonth();
        System.out.println("这个月有" + length + "天");

        // 获取日的两种方式
        int thisDay = today.getDayOfMonth();
        int thisDayAnother = today.get(ChronoField.DAY_OF_MONTH);
        System.out.println("今天是这个月的第" + thisDay + "天");
        System.out.println("今天是这个月的第" + thisDayAnother + "天");

        // 获取星期
        DayOfWeek thisDayOfWeek = today.getDayOfWeek();
        System.out.println(thisDayOfWeek.toString());
        // 今天是这周的第几天
        int dayOfWeek = today.get(ChronoField.DAY_OF_WEEK);
        System.out.println("今天是这周的第" + dayOfWeek + "天");

        // 是否为闰年
        boolean leapYear = today.isLeapYear();
        System.out.println("今年是闰年：" + leapYear);

        //构造指定的年月日
        LocalDate anotherDay = LocalDate.of(2008, 8, 8);
        System.out.println("指定年月日：" + anotherDay);
    }
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


}

