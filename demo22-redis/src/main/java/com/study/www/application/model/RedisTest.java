package com.study.www.application.model;

/**
 * RediTest: Redis测试
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/7    14:09
 **/
public class RedisTest extends RedisBase {
    private String name;
    private String tel;
    private String addr;

    @Override
    public String getRedisKey() {
        return super.getRedisKey();
    }

    @Override
    public void setRedisKey(String redisKey) {
        super.setRedisKey(redisKey);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
