package com.wxy.pojo;

import java.io.File;

/**
 * @author 王鑫垚
 * @version 1.0.0
 * @ClassName StartParse
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class Main {

    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\aaa";

        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs) {
            if (f.isFile()) {
                String newPath ="\\" + f.getName();
                path = path + newPath;
                System.out.println(path);
                path  = path.replace(newPath,"");
                System.out.println(path);
            }
        }
    }
}
