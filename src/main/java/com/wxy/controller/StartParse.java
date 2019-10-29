package com.wxy.controller;

import com.wxy.pojo.Excel;
import com.wxy.pojo.Winrar;
import com.wxy.pojo.Word;

import java.io.File;
import java.util.List;

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

        System.out.println(pathOut+"\\"+ClassName);

        String s = pathOut + "\\" + ClassName;

        path(s);

    }

    public static String path(String path) throws Exception {

        System.out.println("path:"+path);
        File file = new File(path);
        File[] fs = file.listFiles();

        for(File f:fs){
            String newPath ="\\" + f.getName();
            //文件
            if(f.isFile()){
                path = path + newPath;
                if(path.endsWith(".doc")){
                    //读取文件内容
                    Word.docGetText(path);
                    String[] s = Word.docxGetText(path).split("\n");
                    //写入文件内容
                    Excel.WriteContent(s,"");
                    //return path  = path.replace(newPath,"");
                }else if(path.endsWith(".docx")){
                    //读取文件内容
                    Word.docxGetText(path);
                    String[] s = Word.docxGetText(path).split("\n");
                    //写入文件内容
                    Excel.WriteContent(s,"");
                    //return path  = path.replace(newPath,"");
                }else if(path.endsWith(".zip")){
                    Winrar.unzip(path,path.replace(newPath,""));
                    return path(path.substring(0,path.lastIndexOf(".")));
                }else if(path.endsWith(".rar")){
                    Winrar.unrar(path,path.replace(newPath,""));
                    return path(path.substring(0,path.lastIndexOf(".")));
                }
                //目录
            }else if(f.isDirectory()){
                path = path + newPath;
                return path(path);

            }
            return path = path.replace(newPath,"");
        }
        return path;
    }
}
