package com.study.www.entity;

/**
 * PipiInfoSimple: 简化对象
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/24    14:01
 **/
public class PipiInfoSimple {
    private float avgPrice;//平均价
    private String priceUnit;//价格单位
    private String time;//时间
    private String className;//品类
    private float priceSum;//总价
    private int opecNum;//报价数
    private String spec;//规格

    public int getOpecNum() {
        return opecNum;
    }

    public void setOpecNum(int opecNum) {
        this.opecNum = opecNum;
    }

    public float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public float getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(float priceSum) {
        this.priceSum = priceSum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }
}
