package com.wxy.pojo.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CloudResources
 * @Description 云平台资源
 * @Author 张喜春
 * @Date 2019/10/30 10:47
 * @Version 1.0
 */
public class CloudResources {
    List tjCloud = new ArrayList<String>();//太极云
    List jsCloud = new ArrayList<String>();//金山云
    List sxCloud = new ArrayList<String>();//首信云
    List ltCloud = new ArrayList<String>();//联通云
    List lcClout = new ArrayList<String>();//浪潮云
    List dxCloud = new ArrayList<String>();//电信云
    List counts = new ArrayList<String>();//总计

    public CloudResources() {
    }

    public CloudResources(List tjCloud, List jsCloud, List sxCloud, List ltCloud, List lcClout, List dxCloud, List counts) {
        this.tjCloud = tjCloud;
        this.jsCloud = jsCloud;
        this.sxCloud = sxCloud;
        this.ltCloud = ltCloud;
        this.lcClout = lcClout;
        this.dxCloud = dxCloud;
        this.counts = counts;
    }

    public List getTjCloud() {
        return tjCloud;
    }

    public void setTjCloud(List tjCloud) {
        this.tjCloud = tjCloud;
    }

    public List getJsCloud() {
        return jsCloud;
    }

    public void setJsCloud(List jsCloud) {
        this.jsCloud = jsCloud;
    }

    public List getSxCloud() {
        return sxCloud;
    }

    public void setSxCloud(List sxCloud) {
        this.sxCloud = sxCloud;
    }

    public List getLtCloud() {
        return ltCloud;
    }

    public void setLtCloud(List ltCloud) {
        this.ltCloud = ltCloud;
    }

    public List getLcClout() {
        return lcClout;
    }

    public void setLcClout(List lcClout) {
        this.lcClout = lcClout;
    }

    public List getDxCloud() {
        return dxCloud;
    }

    public void setDxCloud(List dxCloud) {
        this.dxCloud = dxCloud;
    }

    public List getCounts() {
        return counts;
    }

    public void setCounts(List counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "CloudResources{" +
                "tjCloud=" + tjCloud +
                ", jsCloud=" + jsCloud +
                ", sxCloud=" + sxCloud +
                ", ltCloud=" + ltCloud +
                ", lcClout=" + lcClout +
                ", dxCloud=" + dxCloud +
                ", counts=" + counts +
                '}';
    }
}
