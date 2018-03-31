package com.study.cn.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * AccessEnum: 权限枚举
 *（1）权限枚举的规则定义如下：XXXX_YY(code,"例子")
 *         其中XXXX为业务模块的缩写
 *         YY为CRUD字母中的其一（代表增删改查）
 *        例如:
 *         BUU--- BASE USER USER 基础模块-用户模块-用户管理
 *          BUU_C(1001,"用户新增"),
 *          BUU_R(1001,"用户查询"),
 *          BUU_U(1002,"用户修改"),
 *          BUU_D(1003,"用户删除")
 * @auther : Administrator.zhuyanpeng
 * @date : 2018/3/5    11:30
 **/
public enum AccessEnum {
    BUU_C(10001,"用户新增") ,
    BUU_R(10003,"用户查询"),
    /*影视*/
    BUM_C(20001,"影视查看") ;

    private int code;
    private String desc;

    private static Map<Object,AccessEnum> pool=new HashMap<Object,AccessEnum>();

    static{
        for (AccessEnum each : AccessEnum.values()) {
            AccessEnum accessEnum = pool.get(each.getCode());
            if (null != accessEnum){
                throw  new RuntimeException(accessEnum.getCode()+"is already exist!");
            }
            pool.put(each.getCode(),each);
            pool.put(each.getDesc(),each);
        }
    }

    AccessEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static AccessEnum findByOne(String msg){
        return pool.get(msg);
    }
}
