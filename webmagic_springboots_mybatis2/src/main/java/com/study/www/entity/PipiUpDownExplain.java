package com.study.www.entity;

/**
 * PipiUpDownExplain: 涨跌说明
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/23    14:36
 **/
public class PipiUpDownExplain extends Pipi{
    private String time;
    private String rankName;
    private String explain;

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
