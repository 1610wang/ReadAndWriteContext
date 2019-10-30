package com.wxy.pojo;

import com.wxy.pojo.entity.Serurity;
import com.wxy.pojo.entity.Weekly;
import com.wxy.pojo.resource.CloudResources;
import com.wxy.pojo.resource.PhysicalDevice;
import com.wxy.pojo.resource.Total;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * @author 张虎
 * @version 1.0.0
 * @ClassName Excel
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class Excel {
    /**
     *  创建一个excel文件并将分析内容写入其中
     * @param path excel文件目标地址
     */
    public static void WriteContent(List<Total> totals, List<Weekly> weeklies, List<Serurity> serurities, String path){
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //入云用户和系统情况
        HSSFSheet sheet1 = creatFirSheet(workbook);
        int i = 3;
        for(Weekly weekly : weeklies){
            HSSFRow row1 = sheet1.createRow(i + 1);
            row1.createCell(0).setCellValue(weekly.getDateTime());
            row1.createCell(1).setCellValue(weekly.getCondition().getUser().getMuniGover());
            row1.createCell(3).setCellValue(weekly.getCondition().getUser().getClient().getTjCloud());
            row1.createCell(4).setCellValue(weekly.getCondition().getUser().getClient().getJsCloud());
            row1.createCell(5).setCellValue(weekly.getCondition().getUser().getClient().getSxCloud());
            row1.createCell(6).setCellValue(weekly.getCondition().getUser().getClient().getLtCloud());
            row1.createCell(7).setCellValue(weekly.getCondition().getUser().getClient().getLcCloud());
            row1.createCell(8).setCellValue(weekly.getCondition().getUser().getClient().getDxCloud());
            row1.createCell(9).setCellValue(weekly.getCondition().getSys().getCount());
            row1.createCell(16).setCellValue(weekly.getCondition().getNewOffice());
            row1.createCell(17).setCellValue(weekly.getCondition().getNewServiceSys());
            row1.createCell(18).setCellValue(weekly.getCondition().getNewOnlineSys());
            row1.createCell(19).setCellValue(weekly.getCondition().getExitSys());
            i++;
        }
        //资源使用情况
        HSSFSheet sheet2 =creatSecSheet(workbook);
        int q = 3;
        for (Total total : totals) {
            CloudResources cloudResource = total.getCloudRes();
            PhysicalDevice device = total.getPhyDev();
            HSSFRow row1 = sheet2.createRow(q);
            row1.createCell(0).setCellValue(cloudResource.getTime());
            int j = 2;
            for (int i1 = 1; i1 < cloudResource.getTjCloud().length; i1++) {
                row1.createCell(j).setCellValue(cloudResource.getTjCloud()[i1]);
                j+=7;
            }

            int n = 3;
            for (int i1 = 1; i1 < cloudResource.getJsCloud().length; i1++) {
                row1.createCell(n).setCellValue(cloudResource.getJsCloud()[i1]);
                n+=7;
            }
            int m = 4;
            for (int i1 = 1; i1 < cloudResource.getSxCloud().length; i1++) {
                row1.createCell(m).setCellValue(cloudResource.getSxCloud()[i1]);
                m+=7;
            }
            int o = 5;
            for (int i1 = 1; i1 < cloudResource.getLtCloud().length; i1++) {
                row1.createCell(o).setCellValue(cloudResource.getLtCloud()[i1]);
                o+=7;
            }

            int p = 6;
            for (int i1 = 1; i1 < cloudResource.getLcCloud().length; i1++) {
                row1.createCell(p).setCellValue(cloudResource.getLcCloud()[i1]);
                p+=7;
            }
            int k = 7;
            for (int i1 = 1; i1 < cloudResource.getDxCloud().length; i1++) {
                row1.createCell(k).setCellValue(cloudResource.getDxCloud()[i1]);
                k+=7;
            }
            int a = 86;
            for (String s : device.getTjCloud()) {
                row1.createCell(a).setCellValue(s);
                a += 7;
            }
            int b = 87;
            for (String s : device.getJsCloud()) {
                row1.createCell(b).setCellValue(s);
                b += 7;
            }
            int c = 88;
            for (String s : device.getSxCloud()) {
                row1.createCell(c).setCellValue(s);
                c+= 7;
            }
            int d = 89;
            for (String s : device.getLtCloud()) {
                row1.createCell(d).setCellValue(s);
                d += 7;
            }
            int e = 90;
            for (String s : device.getLcClout()) {
                row1.createCell(e).setCellValue(s);
                e += 7;
            }
            int f = 91;
            for (String s : device.getDxCloud()) {
                row1.createCell(f).setCellValue(s);
                f += 7;
            }
            q++;
        }


        //云内系统排名时间时间
        String[] cellNames = {"时间（周）","系统访问总量前10名"};
        HSSFSheet sheet3 = creatSheet(workbook,"云内系统排名时间时间",cellNames);

        //安全监控报告1
        String[] cellName = {"时间（天）","受攻击威胁次数"};
        HSSFSheet sheet4 = creatSheet(workbook,"安全监控报告1",cellName);
       //写入数据
        i = 0;
        for(Serurity serurity :serurities){
            HSSFRow row1 = sheet4.createRow(i + 1);
            row1.createCell(0).setCellValue(serurity.getTime());
            row1.createCell(1).setCellValue(serurity.getCount());
            i++;
        }
        //安全监控报告2
        String[] celln = {"时间（周）","单位","受攻击次数"};
        HSSFSheet sheet5 = creatSheet(workbook,"安全监控报告2",cellName);

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

    /**
     * 入云用户和系统使用情况sheet模板
     * @param workbook
     * @return
     */
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

    /**
     * 资源使用情况sheet模板
     * @param workbook
     * @return
     */
    public static HSSFSheet creatSecSheet(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFSheet sheet = workbook.createSheet("资源使用情况");
        sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,28));
        sheet.addMergedRegion(new CellRangeAddress(0,0,29,56));
        sheet.addMergedRegion(new CellRangeAddress(0,0,57,84));
        sheet.addMergedRegion(new CellRangeAddress(0,1,85,91));
        sheet.addMergedRegion(new CellRangeAddress(0,1,92,98));
        sheet.addMergedRegion(new CellRangeAddress(0,1,99,105));
        sheet.addMergedRegion(new CellRangeAddress(0,1,106,112));
        sheet.addMergedRegion(new CellRangeAddress(0,1,113,120));

        sheet.addMergedRegion(new CellRangeAddress(1,1,1,7));
        sheet.addMergedRegion(new CellRangeAddress(1,1,8,14));
        sheet.addMergedRegion(new CellRangeAddress(1,1,15,21));
        sheet.addMergedRegion(new CellRangeAddress(1,1,22,28));
        sheet.addMergedRegion(new CellRangeAddress(1,1,29,35));
        sheet.addMergedRegion(new CellRangeAddress(1,1,36,42));
        sheet.addMergedRegion(new CellRangeAddress(1,1,43,49));
        sheet.addMergedRegion(new CellRangeAddress(1,1,50,56));
        sheet.addMergedRegion(new CellRangeAddress(1,1,57,63));
        sheet.addMergedRegion(new CellRangeAddress(1,1,64,70));
        sheet.addMergedRegion(new CellRangeAddress(1,1,71,77));
        sheet.addMergedRegion(new CellRangeAddress(1,1,78,84));

//        //设置第一行表头
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("时间（周）");
        cell1.setCellStyle(style);
        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("vCPU(核）");
        cell2.setCellStyle(style);
        HSSFCell cell3 = row1.createCell(29);
        cell3.setCellValue("内存（GB)");
        cell3.setCellStyle(style);
        HSSFCell cell4 = row1.createCell(57);
        cell4.setCellValue("存储（TB)");
        cell4.setCellStyle(style);
        HSSFCell cell5 = row1.createCell(85);
        cell5.setCellValue("设备总数");
        cell5.setCellStyle(style);
        HSSFCell cell6 = row1.createCell(92);
        cell6.setCellValue("计算资源池服务器（台）");
        cell6.setCellStyle(style);
        HSSFCell cell7 = row1.createCell(99);
        cell7.setCellValue("其他物理设备数量（台）");
        cell7.setCellStyle(style);
        HSSFCell cell8 = row1.createCell(106);
        cell8.setCellValue("租用物理服务器（台)");
        cell8.setCellStyle(style);
        HSSFCell cell9 = row1.createCell(113);
        cell9.setCellValue("比例");
        cell9.setCellStyle(style);
        //设置第二行和第三行表头
        HSSFRow row2 = sheet.createRow(1);
        HSSFRow row3 = sheet.createRow(2);
        String[] title = {"已使用","总量","占比","同比增长"};
        String[] conten = {"合计","太极云","金山云","首信云","联通云","浪潮云","电信云"};
        int i = 1;
        int n = 1;
        for (int j = 0; j < 3; j++) {
            for (String s : title) {
                HSSFCell hssfCell = row2.createCell(i);
                hssfCell.setCellValue(s);
                hssfCell.setCellStyle(style);
                i += 7;
                for (String s1 : conten) {
                    HSSFCell hssfCell3 = row3.createCell(n);
                    hssfCell3.setCellValue(s1);
                    hssfCell3.setCellStyle(style);
                    n++;
                }
            }
        }
        int m = 85;
        for (int j = 0; j < 5; j++) {
            for (String s : conten) {
                HSSFCell hssfCell3 = row3.createCell(m);
                hssfCell3.setCellValue(s);
                hssfCell3.setCellStyle(style);
                m++;
            }
        }
        return sheet;
    }
}
