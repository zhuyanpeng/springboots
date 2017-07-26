package com.cnnnc.entity;



/**
 * BaseBean: 基础共有属性对象
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/6/6    13:55
 **/
public class BaseBean extends CodeInfoBean {
    private String windCode;
    private int actionDay;
    private String time;
    private char status;
    private String serverTime;

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode;
    }

    public int getActionDay() {
        return actionDay;
    }

    public void setActionDay(int actionDay) {
        this.actionDay = actionDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}
