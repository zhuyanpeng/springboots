package com.study.www.entity;

import java.util.List;

/**
 * PipiUpDownEntity: 大宗商品涨跌榜bean
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/23    14:18
 **/
public class PipiUpDownEntity extends Pipi{
    private String time;//时间
    private String goodsName;//商品
    private String trade;//行业
    private String price;//价格
    private String unit;//单位
    private String dayChg;//日涨跌
    private String monChg;//同比涨跌
    public String getTime() {
        return time;
    }

    public PipiUpDownEntity(String time, String goodsName, String trade, String price, String unit, String dayChg, String monChg) {
        this.time = time;
        this.goodsName = goodsName;
        this.trade = trade;
        this.price = price;
        this.unit = unit;
        this.dayChg = dayChg;
        this.monChg = monChg;
    }

    public PipiUpDownEntity(List<String> list) {
        this.goodsName = list.get(0);
        this.trade = list.get(1);
        this.price = list.get(2);
        this.unit = list.get(3);
        this.dayChg = list.get(4);
        this.monChg = list.get(5);
        this.time = list.get(6);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDayChg() {
        return dayChg;
    }

    public void setDayChg(String dayChg) {
        this.dayChg = dayChg;
    }

    public String getMonChg() {
        return monChg;
    }

    public void setMonChg(String monChg) {
        this.monChg = monChg;
    }

}
