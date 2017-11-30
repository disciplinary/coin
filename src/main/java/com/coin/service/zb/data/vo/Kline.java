package com.coin.service.zb.data.vo;

import java.util.ArrayList;

public class Kline {

 private  String moneyType;

 private  String symbol;
 private ArrayList<KData> kDataList;

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public ArrayList<KData> getkDataList() {
        return kDataList;
    }

    public void setkDataList(ArrayList<KData> kDataList) {
        this.kDataList = kDataList;
    }
}
