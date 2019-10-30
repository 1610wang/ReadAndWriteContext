package com.wxy.pojo.resource.resource;

/**
 * @ClassName Total
 * @Description
 * @Author 张喜春
 * @Date 2019/10/30 10:59
 * @Version 1.0
 */
public class Total {
    private CloudResources cloudRes; //云平台资源
    private PhysicalDevice phyDev; //云平台物理设备情况

    public Total() {
    }

    public Total(CloudResources cloudRes, PhysicalDevice phyDev) {
        this.cloudRes = cloudRes;
        this.phyDev = phyDev;
    }

    public CloudResources getCloudRes() {
        return cloudRes;
    }

    public void setCloudRes(CloudResources cloudRes) {
        this.cloudRes = cloudRes;
    }

    public PhysicalDevice getPhyDev() {
        return phyDev;
    }

    public void setPhyDev(PhysicalDevice phyDev) {
        this.phyDev = phyDev;
    }

    @Override
    public String toString() {
        return "Total{" +
                "cloudRes=" + cloudRes +
                ", phyDev=" + phyDev +
                '}';
    }
}
