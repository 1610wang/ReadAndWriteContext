package com.wxy.pojo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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
        //入云用户和系统情况
        HSSFSheet sheet1 = creatFirSheet(workbook);
        //资源使用情况
        HSSFSheet sheet2 = workbook.createSheet("资源使用情况");
        //云内系统排名时间时间
        String[] cellNames = {"时间（周）","系统访问总量前10名"};
        HSSFSheet sheet3 = creatSheet(workbook,"云内系统排名时间时间",cellNames);
        int i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet3.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            row1.createCell(1).setCellValue(entity);
            row1.createCell(2).setCellValue(entity);
            i++;
        }
        //安全监控报告1
        String[] cellName = {"时间（天）","受攻击威胁次数"};
        HSSFSheet sheet4 = creatSheet(workbook,"安全监控报告1",cellName);
       //写入数据
        i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet4.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            row1.createCell(1).setCellValue(entity);
            row1.createCell(2).setCellValue(entity);
            i++;
        }
        //安全监控报告2
        String[] celln = {"时间（周）","单位","受攻击次数"};
        HSSFSheet sheet5 = creatSheet(workbook,"安全监控报告2",cellName);
        //写入数据
        i = 0;
        for(String entity : s){
            HSSFRow row1 = sheet5.createRow(i + 1);
            row1.createCell(0).setCellValue(entity);
            row1.createCell(1).setCellValue(entity);
            row1.createCell(2).setCellValue(entity);
            i++;
        }
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
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFSheet sheet = workbook.createSheet("入云用户和系统使用情况");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,19));
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("北京政务云工作周报");
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,3,0,0));
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,19));
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,8));
        sheet.addMergedRegion(new CellRangeAddress(2,2,9,15));
        sheet.addMergedRegion(new CellRangeAddress(2,3,16,16));
        sheet.addMergedRegion(new CellRangeAddress(2,3,17,17));
        sheet.addMergedRegion(new CellRangeAddress(2,3,18,18));
        sheet.addMergedRegion(new CellRangeAddress(2,3,19,19));
        //设置第一行表头
        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("时间（周）");
        cell1.setCellStyle(style);
        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("入云用户和系统使用情况");
        cell2.setCellStyle(style);
        //设置第二行表头
        HSSFRow row2 = sheet.createRow(2);
        HSSFCell cell3 = row2.createCell(1);
        cell3.setCellValue("用户数量");
        HSSFCell cell4 = row2.createCell(9);
        cell4.setCellValue("入云系统数量 ");
        HSSFCell cell5 = row2.createCell(16);
        cell5.setCellValue("本周新增委办局");
        HSSFCell cell6 = row2.createCell(17);
        cell6.setCellValue("本周新增业务系统 ");
        HSSFCell cell7 = row2.createCell(18);
        cell7.setCellValue("本周新上线业务系统");
        HSSFCell cell8 = row2.createCell(19);
        cell8.setCellValue("退出业务系统 ");
        cell3.setCellStyle(style);
        cell4.setCellStyle(style);
        cell5.setCellStyle(style);
        cell6.setCellStyle(style);
        cell7.setCellStyle(style);
        cell8.setCellStyle(style);
        //添加第三行表头
        HSSFRow row3 = sheet.createRow(3);
        HSSFCell cell9 = row3.createCell(1);
        cell9.setCellValue("市级委办局 ");
        cell9.setCellStyle(style);
        String[] title = {"总计","太极云","金山云","首信云","联通云","浪潮云","电信云"};
        int rows = 2;
        for (int i = 0; i < title.length; i++) {
            HSSFCell cellTemp = row3.createCell(rows + i);
            cellTemp.setCellValue(title[i]);
            cellTemp.setCellStyle(style);
        }
        rows += title.length;
        for (int i = 0; i < title.length; i++) {
            HSSFCell cellTemp = row3.createCell(rows + i);
            cellTemp.setCellValue(title[i]);
            cellTemp.setCellStyle(style);
        }
        return sheet;
    }
}
