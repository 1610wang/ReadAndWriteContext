package com.wxy.pojo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class Pic {
   public static void picOut(String path,String targtPath) {
//     String path ="C:\\Users\\Administrator\\Desktop\\北京政务云工作周报（20191011第190期）.docx";
     File file = new File(path);
     try {
         FileInputStream fis = new FileInputStream(file);
         XWPFDocument document = new XWPFDocument(fis);
         XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
         String text = xwpfWordExtractor.getText();
         List<XWPFPictureData> picList = document.getAllPictures();
         for (XWPFPictureData pic : picList) {
             byte[] bytev = pic.getData();
             FileOutputStream fos = new FileOutputStream(targtPath+"\\"+pic.getFileName());
             fos.write(bytev);
         }
         fis.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
   }
}