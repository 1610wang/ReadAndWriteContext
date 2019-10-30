package com.wxy.pojo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CloudResources
 * @Description 云平台资源
 * @Author 张喜春
 * @Date 2019/10/30 10:47
 * @Version 1.0
 */
public class CloudResources {
    private String time;
    String[] tjCloud = new String[12];//太极云
    String[] jsCloud = new String[12];//金山云
    String[] sxCloud = new String[12];//首信云
    String[] ltCloud = new String[12];//联通云
    String[] lcCloud = new String[12];//浪潮云
    String[] dxCloud = new String[12];//电信云
    String[] counts = new String[6];//总计

    public CloudResources() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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

    public String[] getLcCloud() {
        return lcCloud;
    }

    public void setLcCloud(String[] lcCloud) {
        this.lcCloud = lcCloud;
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

    @Override
    public String toString() {
        return "CloudResources{" +
                "tjCloud=" + Arrays.toString(tjCloud) +
                ", jsCloud=" + Arrays.toString(jsCloud) +
                ", sxCloud=" + Arrays.toString(sxCloud) +
                ", ltCloud=" + Arrays.toString(ltCloud) +
                ", lcCloud=" + Arrays.toString(lcCloud) +
                ", dxCloud=" + Arrays.toString(dxCloud) +
                ", counts=" + Arrays.toString(counts) +
                '}';
    }
}
