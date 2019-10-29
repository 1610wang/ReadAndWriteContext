package com.wxy.controller;

import com.wxy.pojo.Winrar;
import com.wxy.pojo.Word;

import java.io.File;
/**
 * @author 王鑫垚
 * @version 1.0.0
 * @ClassName StartParse
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class StartParse {

    public static void main(String[] args) {

        String OrginPath = "C:\\Users\\Administrator\\Desktop\\驾驶舱1014.rar";//根目录

        String ClassName = "驾驶舱1014";//文件名

        String pathOut = "C:\\Users\\Administrator\\Desktop\\hello"; //输出目录地址

        Winrar.unrar(OrginPath,pathOut);/*解析压缩包*/

        System.out.println(pathOut+"\\"+ClassName);

        String s = pathOut + "\\" + ClassName;

        path(s);



    }

    public static String path(String path){

        System.out.println("path:"+path);
        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs){
            if(f.isFile()){//文件
                String newPath ="\\" + f.getName();
                path = path + newPath;
                if(path.endsWith(".doc")){
                    Word.docGetText(path);
                    path  = path.replace(newPath,"");
                }else if(path.endsWith(".docx")){
                    Word.docxGetText(path);
                    path  = path.replace(newPath,"");
                }
            }else if(f.isDirectory()){//目录
                String newPath ="\\" + f.getName();
                path = path + newPath;
                return path(path);

            }else {//压缩包
                String newPath = "\\" +f.getName();
                path = path + newPath;
                if(path.endsWith(".zip")){

                }else if(path.endsWith(".rar")){
                    //Winrar.unrar(path,)
                }
                path  = path.replace(newPath,"");
                return path(path);
            }
        }
            return path;
    }
}
