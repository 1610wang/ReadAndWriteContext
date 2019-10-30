package com.wxy.pojo.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhysicalDevice
 * @Description 云平台物理设备情况
 * @Author 张喜春
 * @Date 2019/10/30 10:56
 * @Version 1.0
 */
public class PhysicalDevice {
    //太极云
    String[] tjCloud = new String[5];
    //金山云
    String[] jsCloud = new String[5];
    //首信云
    String[] sxCloud = new String[5];
    //联通云
    String[] ltCloud = new String[5];
    //浪潮云
    String[] lcClout = new String[5];
    //电信云
    String[] dxCloud = new String[5];
    //总计
    String[] counts = new String[5];

    public String[] getTjCloud() {
        return tjCloud;
    }

    public void setTjCloud(String[] tjCloud) {
        this.tjCloud = tjCloud;
    }

    public String[] getJsCloud() {
        return jsCloud;
    }

    public void setJsCloud(String[] jsCloud) {
        this.jsCloud = jsCloud;
    }

    public String[] getSxCloud() {
        return sxCloud;
    }

    public void setSxCloud(String[] sxCloud) {
        this.sxCloud = sxCloud;
    }

    public String[] getLtCloud() {
        return ltCloud;
    }

    public void setLtCloud(String[] ltCloud) {
        this.ltCloud = ltCloud;
    }

    public String[] getLcClout() {
        return lcClout;
    }

    public void setLcClout(String[] lcClout) {
        this.lcClout = lcClout;
    }

    public String[] getDxCloud() {
        return dxCloud;
    }

    public void setDxCloud(String[] dxCloud) {
        this.dxCloud = dxCloud;
    }

    public String[] getCounts() {
        return counts;
    }

    public void setCounts(String[] counts) {
        this.counts = counts;
    }
}
