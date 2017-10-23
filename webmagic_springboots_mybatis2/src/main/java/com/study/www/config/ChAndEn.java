package com.study.www.config;

/**
 * ChAndEn: 中英文标志位三级对照表
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/23    16:40
 **/
public enum ChAndEn {
    GOODSNAME("商品名","goodsName",0),
    TRADE("行业","trade",1),
    PRICE("价格","price",2),
    UNIT("单位","unit",3),
    DAYCHG("日涨跌","dayChg",4),
    monChg("同比涨跌","monChg",5);
    private String ch;
    private String en;
    private Integer order;

    ChAndEn(String ch, String en, Integer order) {
        this.ch = ch;
        this.en = en;
        this.order = order;
    }
    public Integer getIntegerByCH(String ch){
        for (ChAndEn chAndEn : ChAndEn.values()) {
            if (ch.equals(chAndEn.ch)){
                return chAndEn.order;
            }
        }
        return null;
    }
    public String getEnByCH(String ch){
        for (ChAndEn chAndEn : ChAndEn.values()) {
            if (ch.equals(chAndEn.ch)){
                return chAndEn.en;
            }
        }
        return null;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
