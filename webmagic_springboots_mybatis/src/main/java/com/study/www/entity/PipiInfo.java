package com.study.www.entity;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作用说明：生意社
 *
 * @author mirror.zhuyanpeng
 * @create 2017-07-23 19:24
 **/
public class PipiInfo{
    private String priceOrg;//报价机构
    private String priceTyple;//报价类型
    private String priceUnit;//价格单位
    private String origin;//产地
    private float price;//单价
    private String spec;//规格
    private String time;//时间
    private String className;//品类

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPriceOrg() {
        return priceOrg;
    }

    public void setPriceOrg(String priceOrg) {
        this.priceOrg = priceOrg;
    }

    public String getPriceTyple() {
        return priceTyple;
    }

    public void setPriceTyple(String priceTyple) {
        this.priceTyple = priceTyple;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PipiInfo{" +
                "priceOrg='" + priceOrg + '\'' +
                ", priceTyple='" + priceTyple + '\'' +
                ", origin='" + origin + '\'' +
                ", price='" + price + '\'' +
                ", spec='" + spec + '\'' +
                ", time='" + time + '\'' +
                ", className='" + className + '\'' +
                '}'+"\r\n";
    }

    @Override
    public int hashCode() {
        String[] split = time.split("-");
        StringBuffer intStr=new StringBuffer();
        for (String s : split) {
            intStr.append(s);
        }
        Integer integer = Integer.valueOf(intStr.toString());
        for (char c : spec.toCharArray()) {
            integer=integer+((int)c*100);
        }
        for (char c : className.toCharArray()) {
            integer=integer+((int)c*10000);
        }
        return integer;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }
}
