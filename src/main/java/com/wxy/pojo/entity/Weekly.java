package com.wxy.pojo.entity;

import java.util.Date;

/**
 * 工作周报实体类
 */
public class Weekly {
    private Date dateTime; //时间周
    private Condition condition; //用户和系统情况

    public Weekly() {
    }

    public Weekly(Date dateTime, Condition condition) {
        this.dateTime = dateTime;
        this.condition = condition;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
