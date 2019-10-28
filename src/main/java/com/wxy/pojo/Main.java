package com.wxy.pojo;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\aaa";

        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs) {
            if (f.isFile()) {
                String newPath = "" + "\\" + f.getName();
                path = path + newPath;
                System.out.println(path);
                path  = path.replace(newPath,"");
                System.out.println(path);
            }
        }
    }
}
