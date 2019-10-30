package com.wxy.pojo.entity;

/**
 * 情况类
 */
public class Condition {
    private User user; //用户
    private Sys sys; //系统
    private String newOffice; //新增委办局
    private String newServiceSys; //新增业务系统
    private String newOnlineSys; //新上线系统
    private String exitSys; //退出业务系统

    public Condition() {
    }

    public Condition(User user, Sys sys, String newOffice, String newServiceSys, String newOnlineSys, String exitSys) {
        this.user = user;
        this.sys = sys;
        this.newOffice = newOffice;
        this.newServiceSys = newServiceSys;
        this.newOnlineSys = newOnlineSys;
        this.exitSys = exitSys;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSystem(Sys sys) {
        this.sys = sys;
    }

    public String getNewOffice() {
        return newOffice;
    }

    public void setNewOffice(String newOffice) {
        this.newOffice = newOffice;
    }

    public String getNewServiceSys() {
        return newServiceSys;
    }

    public void setNewServiceSys(String newServiceSys) {
        this.newServiceSys = newServiceSys;
    }

    public String getNewOnlineSys() {
        return newOnlineSys;
    }

    public void setNewOnlineSys(String newOnlineSys) {
        this.newOnlineSys = newOnlineSys;
    }

    public String getExitSys() {
        return exitSys;
    }

    public void setExitSys(String exitSys) {
        this.exitSys = exitSys;
    }


    @Override
    public String toString() {
        return "Condition{" +
                "user=" + user +
                ", sys=" + sys +
                ", newOffice='" + newOffice + '\'' +
                ", newServiceSys='" + newServiceSys + '\'' +
                ", newOnlineSys='" + newOnlineSys + '\'' +
                ", exitSys='" + exitSys + '\'' +
                '}';
    }
}
