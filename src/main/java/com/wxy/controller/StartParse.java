package com.wxy.controller;

import java.io.File;

public class StartParse {

    public static void main(String[] args) {

        String OrginPath = "";//根目录

        /*解析压缩包*/

        String path = "";//解析完路径

        path(path);

    }

    public static String path(String path){

        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs){
            if(f.isFile()){
                path = path + "\\" +f.getName();
                if(path.endsWith(".doc")){

                }else if(path.endsWith(".docx")){

                }else if(f.isDirectory()){
                    path = path + "\\" +f.getName()+f.getName().lastIndexOf(".");
                    return path(path);
                }else {
                    /*解压方法*/
                    path = path + "";
                    path(path);
                }
            }
        }
            return path;

    }


}
