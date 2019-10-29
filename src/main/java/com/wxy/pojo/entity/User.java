package com.wxy.pojo.entity;

/**
 * 用户类
 */
public class User {
    private Integer count;  //总计
    private String muniGover; //市级委办
    private Client client; //客户

    public User() {
    }

    public User(Integer count, String muniGover, Client client) {
        this.count = count;
        this.muniGover = muniGover;
        this.client = client;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMuniGover() {
        return muniGover;
    }

    public void setMuniGover(String muniGover) {
        this.muniGover = muniGover;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "User{" +
                "count=" + count +
                ", muniGover='" + muniGover + '\'' +
                ", client=" + client +
                '}';
    }
}
