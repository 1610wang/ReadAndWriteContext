package com.wxy.pojo;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 张虎
 * @version 1.0.0
 * @ClassName Word
 * @Description TODO
 * @createTime 2019年10月28日 17:45:00
 */
public class Word {
    /**
     * 读取doc文件
     * @param path
     * @return
     */
    public static String docGetText(String path){
        String buffer = "";
        try {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 读取docx文件
     * @param path
     * @return
     */
    public static String docxGetText(String path){
        String buffer = "";

        try {
            OPCPackage opcPackage = POIXMLDocument.openPackage(path);
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            buffer = extractor.getText();
            extractor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 判断对应文件采取对应的方法
     * @param path
     * @return
     */
    public static String getText(String path){
        if(path.endsWith(".doc")){
            return docGetText(path);
        }else if(path.endsWith("docx")){
            return docxGetText(docxGetText(path));
        }else {
            return "这个文件不是word文件";
        }
    }

    /**
     * 解析Word获取所需要的内容
     * @param word
     */
    public static void splitWord(String word){

    }
}
