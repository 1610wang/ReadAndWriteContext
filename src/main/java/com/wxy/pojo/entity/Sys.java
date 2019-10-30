package com.wxy.pojo.entity;

/**
 * @Author: 王鑫垚
 * @Description:
 * @Date: Create in 10:05 2019/10/30
 */
public class Sys {
/**
 * 系统类
 */

    private String count;  //总计
    private Client client;  //客户

    public Sys() {
    }

    public Sys(String count, Client client) {
        this.count = count;
        this.client = client;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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
