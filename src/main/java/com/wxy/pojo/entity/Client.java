package com.wxy.pojo.entity;

/**
 * 抽取公共类
 */
public class Client {
    private String tjCloud; //太极云
    private String jsCloud; //金山云
    private String sxCloud; //首信云
    private String ltCloud; //联通云
    private String lcCloud; //浪潮云
    private String dxCloud; //电信云

    public Client() {
    }

    public Client(String tjCloud, String jsCloud, String sxCloud, String ltCloud, String lcCloud, String dxCloud) {
        this.tjCloud = tjCloud;
        this.jsCloud = jsCloud;
        this.sxCloud = sxCloud;
        this.ltCloud = ltCloud;
        this.lcCloud = lcCloud;
        this.dxCloud = dxCloud;
    }

    public String getTjCloud() {
        return tjCloud;
    }

    public void setTjCloud(String tjCloud) {
        this.tjCloud = tjCloud;
    }

    public String getJsCloud() {
        return jsCloud;
    }

    public void setJsCloud(String jsCloud) {
        this.jsCloud = jsCloud;
    }

    public String getSxCloud() {
        return sxCloud;
    }

    public void setSxCloud(String sxCloud) {
        this.sxCloud = sxCloud;
    }

    public String getLtCloud() {
        return ltCloud;
    }

    public void setLtCloud(String ltCloud) {
        this.ltCloud = ltCloud;
    }

    public String getLcCloud() {
        return lcCloud;
    }

    public void setLcCloud(String lcCloud) {
        this.lcCloud = lcCloud;
    }

    public String getDxCloud() {
        return dxCloud;
    }


    public void setDxCloud(String dxCloud) {
        this.dxCloud = dxCloud;
    }


    @Override
    public String toString() {
        return "Client{" +
                "tjCloud='" + tjCloud + '\'' +
                ", jsCloud='" + jsCloud + '\'' +
                ", sxCloud='" + sxCloud + '\'' +
                ", ltCloud='" + ltCloud + '\'' +
                ", lcCloud='" + lcCloud + '\'' +
                ", dxCloud='" + dxCloud + '\'' +
                '}';
    }
}
