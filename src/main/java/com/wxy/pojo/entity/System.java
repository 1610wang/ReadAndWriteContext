package com.wxy.pojo.entity;

/**
 * 系统类
 */
public class System{
    private Integer count;  //总计
    private Client client;  //客户

    public System() {
    }

    public System(Integer count, Client client) {
        this.count = count;
        this.client = client;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "System{" +
                "count=" + count +
                ", client=" + client +
                '}';
    }
}
