package com.coin;

public class Test {

    public static void main(String[] args) {
        Double closeOne= new Double("10.04");
        Double closeTwo= new Double("10.02");
        Double closeThree= new Double("10.01");
        String content;
        String currency= "a";
        if(closeOne.compareTo(closeTwo)>0&&closeTwo.compareTo(closeThree)>0){
            content=currency+"倒数一分钟收盘价="+closeOne+"倒数第二分钟收盘价="+closeTwo+"倒数第三分钟收盘价="+closeThree;
            System.out.println(content);
        }
    }
}
