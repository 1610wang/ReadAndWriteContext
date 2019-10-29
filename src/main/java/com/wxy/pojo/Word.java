package com.wxy.pojo;

import com.wxy.pojo.entity.Client;
import com.wxy.pojo.entity.Condition;
import com.wxy.pojo.entity.User;
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
    public static void getData(String buffer){
        String[] s = buffer.split("威胁");
        String[] s1 = s[1].split("次");
        System.out.println(s1[0]);
    }

    /**
     * 解析获得入云用户和系统情况
     * @param word
     * @return
     */
    public static Condition splitWord(String word){
        Condition condition = new Condition();
        User user = new User();
        Client client = new Client();
        String[] temp = word.split("\n");
        String[] strings = temp[5].split("[（]");
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        //新增业务系统
        Matcher m = p.matcher(temp[7]);
        condition.setNewServiceSys(m.replaceAll("").trim());
        //市级委办局数量
        m = p.matcher(strings[0]);
        user.setMuniGover(m.replaceAll("").trim());
        //详细用户数量
        String clientString = strings[1].split("[）]")[0];
        String[] clients = clientString.split("，");
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
        //新增委办局
        m = p.matcher(temp[6]);
        condition.setNewOffice(m.replaceAll("").trim());
        //新上线系统
        m = p.matcher(temp[18]);
        condition.setNewOnlineSys(m.replaceAll("".trim()));
        //退出业务系统
        m = p.matcher(temp[19]);
        condition.setExitSys(m.replaceAll("").trim());
        condition.setUser(user);
        user.setClient(client);
        return condition;
    }
}
