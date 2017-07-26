package com.cnnnc.entity;



/**
 * TdfCodeInfoBean: 基本代码信息
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/6/6    13:59
 **/
public class CodeInfoBean {
    private int type;
    private String code;
    private String name;
    private String gainTime;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGainTime() {
        return gainTime;
    }

    public void setGainTime(String gainTime) {
        this.gainTime = gainTime;
    }
}
