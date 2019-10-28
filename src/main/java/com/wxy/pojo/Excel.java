package com.wxy.pojo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
}
