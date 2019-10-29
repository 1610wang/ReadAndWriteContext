package com.wxy.pojo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 张虎
 * @version 1.0.0
 * @ClassName Excel
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class Excel {
    /**
     * 将解析获取到的内容写入到excel中
     * @param s
     */
    public static void WriteContent(String[] s,String path){
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二步，在workbook中创建一个sheet对应excel中的sheet
//        HSSFSheet sheet = workbook.createSheet("存储文件");
//        //第三步，在sheet表中添加表头第0行
//        HSSFRow row = sheet.createRow(0);
//        //第四步，创建单元格，设置表头
//        HSSFCell cell = row.createCell(0);
//        cell.setCellValue("表头在哪里");
//        cell = row.createCell(1);
//        cell.setCellValue("表头在哪2");
//        cell = row.createCell(2);
//        cell.setCellValue("表头在哪2");
//        //第五步，写入实体数据
//        int i = 0;
//        for(String entity : s){
//            HSSFRow row1 = sheet.createRow(i + 1);
//            row1.createCell(0).setCellValue(entity);
//            row1.createCell(1).setCellValue(entity);
//            row1.createCell(2).setCellValue(entity);
//            i++;
//        }
        //将文件保存到指定的位置
        String[] cellNames = new String[2];
        cellNames[0] = "时间";
        cellNames[1] = "使用情况";
        HSSFSheet sheet1 = creatSheet(workbook,"使用情况",cellNames);
        //        //第五步，写入实体数据
        int i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet1.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            row1.createCell(1).setCellValue(entity);
            i++;
        }
        String[] cellName = new String[3];
        cellName[0] = "时间";
        cellName[1] = "使用情况";
        cellName[2] = "????";
        HSSFSheet sheet2 = creatSheet(workbook,"使用情11",cellName);
        //        //第五步，写入实体数据
        i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet2.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            row1.createCell(1).setCellValue(entity);
            row1.createCell(2).setCellValue(entity);
            i++;
        }
        creatFirSheet(workbook);
        try {
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("失败");
        }
    }

    /**
     * 仅适用于创建简单的sheet，每个表头站一列
     * @param workbook
     * @param sheetName
     * @param cellNames
     * @return
     */
    public static HSSFSheet creatSheet(HSSFWorkbook workbook,String sheetName,String[] cellNames){
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //第三步，在sheet表中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        if(cellNames.length > 0){
            cell.setCellValue(cellNames[0]);
            for (int i = 1; i < cellNames.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(cellNames[i]);
            }
            return sheet;
        }else {
            return null;
        }
    }
    public static HSSFSheet creatFirSheet(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.createSheet("入云用户和系统使用情况");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("北京政务云工作周报");
        sheet.addMergedRegion(new CellRangeAddress(1,3,0,0));
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,19));
        //设置第一行表头
        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("时间（周）");
        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("入云用户和系统使用情况");
        //设置第二行表头
        return null;
    }
}
