package com.wxy.controller;

import com.wxy.pojo.Excel;
import com.wxy.pojo.Winrar;
import com.wxy.pojo.Word;

import java.io.File;
import java.nio.file.Files;
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
                        String pattern = ".*市级政务云工作周报.*||.*政务云平台安全监控报告.*";
                        boolean isMatch = Pattern.matches(pattern, f1.getName());
                        if(isMatch==true){
                            Word.docxGetText(path+newPathFile);
                            System.out.println(f1.getName());
                        }
                    }
                    path = pathOut;
                }
            }
        }


        /*for(File f:fs){
            String newPath ="\\" + f.getName();
            //文件
            if(f.isFile()){
                path = path + newPath;
                System.out.println(path);
                if(path.endsWith(".doc")){
                    //读取文件内容
                    Word.docGetText(path);
                    String[] s = Word.docxGetText(path).split("\n");
                    //写入文件内容
                    //Excel.WriteContent(s,pathOut+f.getName().lastIndexOf(".")+"xls");
                    path  = path.replace(newPath,"");
                }else if(path.endsWith(".docx")){
                    //读取文件内容
                    Word.docxGetText(path);
                    System.out.println("docx:"+Word.docxGetText(path));
                    String[] s = Word.docxGetText(path).split("\n");
                    //写入文件内容
                    //Excel.WriteContent(s,pathOut+f.getName().lastIndexOf(".")+"xls");
                    path  = path.replace(newPath,"");
                }else if(path.endsWith(".zip")){
                    Winrar.unzip(path,path.replace(newPath,""));
                    path(path.substring(0,path.lastIndexOf(".")));
                }else if(path.endsWith(".rar")){
                    Winrar.unrar(path,path.replace(newPath,""));
                    path(path.substring(0,path.lastIndexOf(".")));
                }else {
                    path = path.replace(newPath,"");
                    continue;

                }
                //目录
            }else if(f.isDirectory()){
                path = path + newPath;
                path(path);
            }
            path(path.replace(newPath,""));
        }*/
        return path;
    }
}
