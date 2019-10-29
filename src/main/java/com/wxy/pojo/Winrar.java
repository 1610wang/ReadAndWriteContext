package com.wxy.pojo;



import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import java.io.*;
import java.util.Enumeration;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
/**
 * @author 王鑫垚
 * @version 1.0.0
 * @ClassName Winrar
 * @Description TODO
 * @createTime 2019年10月28日 18:52:00
 */
public class Winrar {

    public static final String winrarPath = "C://Program Files//WinRAR//WinRAR.exe";
    public static boolean unrar(String rarFile, String target) {
        boolean bool = false;
        File f=new File(rarFile);
        if(!f.exists()){
            return false;
        }
        String cmd = winrarPath + " X " + rarFile + " "+target;
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            if (proc.waitFor() != 0) {
                if (proc.exitValue() == 0) {
                    bool = false;
                }
            } else {
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    //解压zip格式压缩包
    private static void unzip(String sourceZip,String destDir) throws Exception{
        try{
            Project p = new Project();
            Expand e = new Expand();
            e.setProject(p);
            e.setSrc(new File(sourceZip));
            e.setOverwrite(false);
            e.setDest(new File(destDir));
            e.setEncoding("gbk");
            e.execute();
        }catch(Exception e){
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        String rarFile= "C:\\Users\\Administrator\\Desktop\\驾驶舱1014.rar";
        String zipFile= "D://a.zip";
        String rartarget= "D://123//";
        String ziptarget= "D://456//";
        //unzip(zipFile, ziptarget);
        unrar(rarFile,"C:\\Users\\Administrator\\Desktop\\hello");
        //boolean b = unrar(rarFile, rartarget);
        //System.out.println(b);
    }
}
