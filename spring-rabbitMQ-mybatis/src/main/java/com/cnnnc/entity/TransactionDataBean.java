package com.cnnnc.entity;



/**
 * TDFTransactionDataBean: 逐笔成交
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/6/6    18:08
 **/
public class TransactionDataBean extends BaseBean {
         private int index;
         private long price;
         private long turnover;
         private String BSFlag;
         private int valume;
         private int volume;
         private char orderKind;
         private char functionCode;
         private int askOrder;
         private int bidOrder;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTurnover() {
        return turnover;
    }

    public void setTurnover(long turnover) {
        this.turnover = turnover;
    }

    public String getBSFlag() {
        return BSFlag;
    }

    public void setBSFlag(String BSFlag) {
        this.BSFlag = BSFlag;
    }

    public int getValume() {
        return valume;
    }

    public void setValume(int valume) {
        this.valume = valume;
        this.volume=valume;
    }

    public int getVolume() {
        return volume;
    }

    public char getOrderKind() {
        return orderKind;
    }

    public void setOrderKind(char orderKind) {
        this.orderKind = orderKind;
    }

    public char getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(char functionCode) {
        this.functionCode = functionCode;
    }

    public int getAskOrder() {
        return askOrder;
    }

    public void setAskOrder(int askOrder) {
        this.askOrder = askOrder;
    }

    public int getBidOrder() {
        return bidOrder;
    }

    public void setBidOrder(int bidOrder) {
        this.bidOrder = bidOrder;
    }
}
