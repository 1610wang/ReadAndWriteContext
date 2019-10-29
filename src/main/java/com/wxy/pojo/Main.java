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
        String[] s = new String[10];
        for (int i = 0; i < s.length; i++) {
            s[i] = "1424";
        }
        String path = "C:/Users/Administrator/Desktop/test.xls";
        Excel.WriteContent(s,path);
    }
}
