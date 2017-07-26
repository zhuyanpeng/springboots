package com.cnnnc.entity;




/**
 * TDFOrderQueueBean: 委托队列
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/6/6    18:28
 **/
public class OrderQueueBean extends BaseBean{
    private String side;
    private long price;
    private int orders;
    private int ABItems;
    private int[] ABVloume;


    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getABItems() {
        return ABItems;
    }

    public void setABItems(int ABItems) {
        this.ABItems = ABItems;
    }

    public int[] getABVloume() {
        return ABVloume;
    }

    public void setABVloume(int[] ABVloume) {
        this.ABVloume = ABVloume;
    }
}
