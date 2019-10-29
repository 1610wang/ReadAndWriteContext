package com.wxy.pojo.entity;

import java.util.Date;

/**
 * 工作周报实体类
 */
public class Weekly {
    private String dateTime; //时间周
    private Condition condition; //用户和系统情况

    public Weekly() {
    }

    public Weekly(String dateTime, Condition condition) {
        this.dateTime = dateTime;
        this.condition = condition;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    @Override
    public String toString() {
        return "Weekly{" +
                "dateTime=" + dateTime +
                ", condition=" + condition +
                '}';
    }
}
