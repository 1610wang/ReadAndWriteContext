package com.wxy.controller;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class ReadContent {

    public static void main(String[] args) throws Exception {


        //unRar(new File("C:\\Users\\Administrator\\Desktop\\驾驶舱1014.rar"),"C:\\Users\\Administrator\\Desktop\\驾驶舱1014");

        String path = "C:/Users/Administrator/Desktop/驾驶舱1014/驾驶舱1014/20180105/20180105/市级政务云工作周报20180105（第103期）V1.0.docx";

        String content = getText(path);

        String[] s = content.split("\n");

        WriteContent(s);

    }


    public static String getText(String path){

        String buffer = "";

        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    public static void WriteContent(String[] s){
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二步，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("存储文件");
        //第三步，在sheet表中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("1");
        /*cell = row.createCell(1);
        cell.setCellValue("2");*/
        //第五步，写入实体数据
        int i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            //row1.createCell(1).setCellValue(entity.getValue());
            i++;
        }
        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/Write.xls");
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("失败");
        }
    }




    /*public static void unZip(File zipFile, String outDir) throws IOException {

        File outFileDir = new File(outDir);

        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration enumeration = zip.getEntries(); enumeration.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) enumeration.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);

            if (entry.isDirectory()) {      //处理压缩文件包含文件夹的情况
                File fileDir = new File(outDir + zipEntryName);
                fileDir.mkdir();
                continue;
            }

            File file = new File(outDir, zipEntryName);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) > 0) {
                out.write(buff, 0, len);
            }
            in.close();
            out.close();
        }
    }

    public static void unRar(File rarFile, String outDir) throws Exception {
        File outFileDir = new File(outDir);
        Archive archive = new Archive(new FileInputStream(rarFile));
        FileHeader fileHeader = archive.nextFileHeader();
        while (fileHeader != null) {
            if (fileHeader.isDirectory()) {
                fileHeader = archive.nextFileHeader();
                continue;
            }
            File out = new File(outDir + fileHeader.getFileNameString());
            if (!out.exists()) {
                if (!out.getParentFile().exists()) {
                    out.getParentFile().mkdirs();
                }
                out.createNewFile();
            }
            FileOutputStream os = new FileOutputStream(out);
            archive.extractFile(fileHeader, os);

            os.close();

            fileHeader = archive.nextFileHeader();
        }
        archive.close();
    }*/

}

