package com.wxy.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wxy.pojo.*;
import com.wxy.pojo.entity.Serurity;
import com.wxy.pojo.entity.Weekly;
import com.wxy.pojo.resource.CloudResources;
import com.wxy.pojo.resource.PhysicalDevice;
import com.wxy.pojo.resource.Rent;
import com.wxy.pojo.resource.Total;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @author 王鑫垚
 * @version 1.0.0
 * @ClassName StartParse
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class StartParse {

    public static List<Weekly> weeklies = new ArrayList<>();
    public static List<Serurity> serurities = new ArrayList<>();
    public static List<Total> totals = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        //根目录
        String OrginPath = "C:\\Users\\Administrator\\Desktop\\驾驶舱1014.rar";
        //文件名
        String ClassName = "驾驶舱1014";
        //输出目录地址
        String pathOut = "C:\\Users\\Administrator\\Desktop\\hello";
        /*解析压缩包*/
        Winrar.unrar(OrginPath,pathOut);

        String s = pathOut + "\\" + ClassName;

        path(s);

    }

    public static String path(String path) throws Exception {
        String pathOut = "C:\\Users\\Administrator\\Desktop\\hello\\驾驶舱1014";
        File file = new File(path);
        File[] fs = file.listFiles();

        for(File f:fs){
            String newPath = "\\"+f.getName();
            if(f.isFile()){
                path = path + newPath;
                if(path.endsWith(".zip")){
                    Winrar.unzip(path,pathOut);
                    path = pathOut +"\\"+ f.getName().substring(0,f.getName().lastIndexOf("."));
                    System.out.println("path:"+path);
                    File file1 = new File(path);
                    File[] fs1 = file1.listFiles();
                    for(File f1:fs1){
                        String newPathFile = "\\"+f1.getName();

                        String pattern = ".*北京政务云工作周报.*";
                        String pattern2 = ".*政务云平台安全监控报告.*";

                        boolean isMatch = Pattern.matches(pattern, f1.getName());
                        boolean isMatch2 = Pattern.matches(pattern2, f1.getName());

                        if(isMatch==true){
                            String word = Word.docxGetText(path+newPathFile);
                            /*获取图片*/
                            Pic.picOut(path+newPathFile,path);
                            String ww = Sample.sample(path + "\\image5.png");
                            if(ww.indexOf("云内业务系统访问总量前十") != -1){
                                Word.num(ww);
                            }else {
                                ww = Sample.sample(path + "\\image10.png");
                                if(ww.indexOf("云内业务系统访问总量前十") != -1){
                                    Word.num(ww);
                                }else {
                                    ww = Sample.sample(path + "\\image11.png");
                                    Word.num(ww);
                                }
                            }

                            /*工作周报*/
                            Weekly weekly = new Weekly();
                            weekly.setCondition(Word.splitWord(word));
                            weekly.setDateTime(Word.getTime(path+newPathFile));
                            weeklies.add(weekly);
                            /*资源使用情况*/
                            CloudResources cloud = Word.splitResource(word);
                            cloud.setTime(Word.getTime(path+newPathFile));
                            /*物理设备使用*/
                            PhysicalDevice physicalDevice = new PhysicalDevice();
                            physicalDevice = Word.splitPhysicalDevice(word);
                            Rent rent = Word.rent(word);
                            Total total = new Total();
                            total.setCloudRes(cloud);
                            total.setPhyDev(physicalDevice);
                            total.setRent(rent);
                            totals.add(total);
                        }else if(isMatch2==true){
                            /*安全监控报告*/
                            Serurity serurity = new Serurity();
                            serurity.setTime(Word.getTime(path+newPathFile));
                            serurity.setCount(Word.getCount(Word.docxGetText(path+newPathFile)));
                            serurities.add(serurity);

                        }else {
                            continue;
                        }
                    }
                    path = pathOut;
                }
            }
        }

        Excel.WriteContent(totals,weeklies,serurities,"C:\\Users\\Administrator\\Desktop\\数据提取内容.xls");
        return path;
    }
}
