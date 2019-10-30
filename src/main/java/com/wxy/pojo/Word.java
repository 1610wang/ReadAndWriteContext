package com.wxy.pojo;

import com.wxy.pojo.entity.Client;
import com.wxy.pojo.entity.Condition;
import com.wxy.pojo.entity.Sys;
import com.wxy.pojo.entity.User;
import com.wxy.pojo.resource.CloudResources;
import com.wxy.pojo.resource.PhysicalDevice;
import com.wxy.pojo.resource.Total;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        }else if(path.endsWith(".docx")){
            return docxGetText(path);
        }else {
            return "这个文件不是word文件";
        }
    }

    /**
     *安全监控报告1
     * @param buffer
     */
    public static String getCount(String buffer){
        String[] s = buffer.split("威胁");
        String[] s1 = s[1].split("次");
        return s1[0];
    }

    /*
    * 安全监控报告
    * */
    public static String getTime(String path){
        File file = new File(path);
        String fileName = file.getName();

        return fileName;
    }

    /**
     * 解析获得入云用户和系统情况
     * @param word
     * @return
     */
    public static Condition splitWord(String word){
        Condition condition = new Condition();
        Sys sys = new Sys();
        User user = new User();
        Client client = new Client();
        String[] temp = word.split("\n");
        String[] strings = temp[5].split("[（]");
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        //入云系统总数
        String ruCloud = word.split("入云系统")[1];
        String ruCloud1 = ruCloud.split("个")[0];
        sys.setCount(ruCloud1);
        condition.setSystem(sys);
        //新增业务系统
        Matcher m = p.matcher(temp[7]);
        condition.setNewServiceSys(m.replaceAll("").trim());
        //市级委办局数量
        m = p.matcher(strings[0]);
        user.setMuniGover(m.replaceAll("").trim());
        //详细用户数量
        String clientString = strings[1].split("[）]")[0];
        String[] clients = clientString.split("，");
        if(clients.length == 1){
            clients = clientString.split("、");
        }
        m = p.matcher(clients[0]);
        client.setTjCloud(m.replaceAll("").trim());
        m = p.matcher(clients[1]);
        client.setJsCloud(m.replaceAll("").trim());
        m = p.matcher(clients[2]);
        client.setSxCloud(m.replaceAll("").trim());
        m = p.matcher(clients[3]);
        client.setLtCloud(m.replaceAll("").trim());
        m = p.matcher(clients[4]);
        client.setLcCloud(m.replaceAll("").trim());
        if(clients.length > 5){
            m = p.matcher(clients[5]);
            client.setDxCloud(m.replaceAll("").trim());
        }
        //新增委办局
        m = p.matcher(temp[6]);
        condition.setNewOffice(m.replaceAll("").trim());
        //新上线系统
        String newSys = word.split("本周新上线业务系统")[1];
        String newSys3 = newSys.split("个")[0];
        String newSys1 = "";
        String outSys= "";
        String[] Sys = newSys.split("本周下线业务系统");
        if(Sys.length == 1){
            newSys1 = newSys.split("本周退出业务系统")[0];
            outSys = newSys.split("本周退出业务系统")[1];
        }else {
            newSys1 = newSys.split("本周下线业务系统")[0];
            outSys = newSys.split("本周下线业务系统")[1];
        }
                m = p.matcher(newSys3);
        condition.setNewOnlineSys(m.replaceAll("".trim()));
        //退出业务系统

        String outSys1 = outSys.split("个")[0];
        m = p.matcher(outSys1);
        condition.setExitSys(m.replaceAll("").trim());
        condition.setUser(user);
        user.setClient(client);
        return condition;
    }

    /**
     * 解析获得资源使用情况
     * @param word
     * @return
     */
    public static CloudResources splitResource(String word){
        Total total = new Total();
        CloudResources cloudResources = new CloudResources();
        PhysicalDevice physicalDevice = new PhysicalDevice();
        String tjCloud = word.split("资源使用情况")[1];
        String temp = tjCloud.split("太极云")[1];
        String wlCloud = temp.split("云平台物理设备情况")[0];
        String jscloud = wlCloud.split("金山云")[0];//太极云
        String jscloud1 = wlCloud.split("金山云")[1];
        String sxCloud =jscloud1.split("首信云")[0];//金山云
        String sxCloud1 =jscloud1.split("首信云")[1];
        String ltCloud  = sxCloud1.split("联通云")[0];//首信云
        String ltCloud1  = sxCloud1.split("联通云")[1];
        String lcCloud = ltCloud1.split("浪潮云")[0];//联通云
        String lcCloud1 = ltCloud1.split("浪潮云")[1];
        String dxCloud = lcCloud1.split("电信云")[0];//浪潮云
        String[] dx = lcCloud1.split("电信云");//电信云
        String dxCloud1 = "";
        if(dx.length > 1){
            dxCloud1 = dx[1].split("云服务商")[0].trim();
        }


        String[] s1 = jscloud.split("\t");
        String[] s2 = sxCloud.split("\t");
        String[] s3 = ltCloud.split("\t");
        String[] s4 = lcCloud.split("\t");
        String[] s5 = dxCloud.split("\t");
        String[] s6 = dxCloud1.split("\t");


        cloudResources.setTjCloud(s1);
        cloudResources.setJsCloud(s2);
        cloudResources.setSxCloud(s3);
        cloudResources.setLtCloud(s4);
        cloudResources.setLcCloud(s5);
        cloudResources.setDxCloud(s6);

        return cloudResources;

    }
    /**
     *  云平台物理设备
     */
    public static PhysicalDevice splitPhysicalDevice(String word){
        Total total = new Total();
        PhysicalDevice physicalDevice = new PhysicalDevice();
        String pdCloud = word.split("云平台物理设备情况")[1];
        String pdCloud1 = pdCloud.split("云服务商排名情况")[0];
        String tjCloud = pdCloud1.split("太极云")[1];
        String tjCloud1 = tjCloud.split("金山云")[0];//太极云
        String jsCloud = tjCloud.split("金山云")[1];
        String jsCloud1 = jsCloud.split("首信云")[0];
        String sxCloud = jsCloud.split("首信云")[1];
        String sxCloud1 = sxCloud.split("联通云")[0];
        String ltCloud = sxCloud.split("联通云")[1];
        String ltCloud1 = ltCloud.split("浪潮云")[0];
        String lcCloud1 = ltCloud.split("浪潮云")[1].split("电信云")[0];
        String[] temp = ltCloud.split("浪潮云")[1].split("电信云");
        String dxCloud = "";
        if(temp.length > 1){
            dxCloud = temp[1].split("云服务商")[0].trim();
        }
        tjCloud1 = tjCloud1.trim();
        jsCloud1 = jsCloud1.trim();
        sxCloud1 = sxCloud1.trim();
        ltCloud1 = ltCloud1.trim();
        lcCloud1 = lcCloud1.trim();


        String[] s1 = tjCloud1.split("\t");
        String[] s2 = jsCloud1.split("\t");
        String[] s3 = sxCloud1.split("\t");
        String[] s4 = ltCloud1.split("\t");
        String[] s5 = lcCloud1.split("\t");
        String[] s6 = dxCloud.split("\t");
        physicalDevice.setTjCloud(s1);
        physicalDevice.setJsCloud(s2);
        physicalDevice.setSxCloud(s3);
        physicalDevice.setLtCloud(s4);
        physicalDevice.setLcClout(s5);
        physicalDevice.setDxCloud(s6);

        return physicalDevice;
    }

}
