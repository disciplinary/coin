package com.coin.utils;

import java.math.BigDecimal;

public class CalculateUtils {
    /**
     * 加法
     *
     * @param var1
     * @param var2
     * @return
     */
    public static double add(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(Double.toString(var1));
        BigDecimal b2 = new BigDecimal(Double.toString(var2));
        return b1.add(b2).doubleValue();

    }

    /**
     * 减法
     *
     * @param var1
     * @param var2
     * @return
     */

    public static double sub(double var1, Double var2) {
        BigDecimal b1 = new BigDecimal(Double.toString(var1));
        BigDecimal b2 = new BigDecimal(Double.toString(var2));
        return b1.subtract(b2).doubleValue();
    }


    /**
     * 第一个说大数且多于第二个数返回true
     *
     * @param var1
     * @param var2
     * @return
     */
    public static boolean compareTo(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(Double.toString(var1));
        BigDecimal b2 = new BigDecimal(Double.toString(var2));
        if(b1.signum()==-1){//判断是否负数
            b1=b1.negate();//此方法返回的对象的负值，即： -this
        }
        if(b1.compareTo(b2)>=0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 乘法
     *
     * @param var1
     * @param var2
     * @return
     */
    public static double mul(double var1, double var2) {
        BigDecimal b1 = new BigDecimal(Double.toString(var1));
        BigDecimal b2 = new BigDecimal(Double.toString(var2));
        return b1.multiply(b2).doubleValue();
    }
    /**
     * 除法
     *
     * @param v1
     * @param v2
     * @param scale 精度，到小数点后几位
     * @return
     */

    public static double div(double v1, double v2, int scale) {

        if (scale < 0) {

            throw new IllegalArgumentException("The scale must be a positive integer or ");

        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }


    /**
     *   第一个比第二个参数的涨幅(正负)
     * @param v1   高
     * @param v2 低
     * @return amplitude 幅度
     */

    public static double amplitude(double v1, double v2) {
        return mul(div(v1-v2,v2,4),100);
    }
    /**
     * 四舍五入
     * @param v
     * @param scale 精确位数
     * @return
     */
    public static double round(double v, int scale) {

        if (scale < 0) {

            throw new IllegalArgumentException("The scale must be a positive integer or zero");

        }

        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }



    public static void main(String[] args) {
        System.out.println("------------》"+amplitude(514.02,485.97));
    }
}