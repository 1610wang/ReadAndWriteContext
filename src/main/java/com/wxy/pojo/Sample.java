package com.wxy.pojo;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author 张虎
 * @version 1.0.0
 * @ClassName Sample
 * @Description TODO
 * @createTime 2019年10月31日 13:54:00
 */
public class Sample {
    public static final String APP_ID = "17661247";
    public static final String API_KEY = "qPdLVEaDRu95Tz1NwLaCHKp1";
    public static final String SECRET_KEY = "g5tA9MhDxwY78ASoLw93DOtISDRK7sCR";

    public static String sample(String path) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");


        // 参数为本地路径
        JSONObject res = client.basicAccurateGeneral(path, options);
//        System.out.println(res.toString(2));

        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.basicAccurateGeneral(file, options);
        return res.toString(2);
    }

    public static String getWord(String picPath) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        // 调用接口

        JSONObject res = client.basicGeneral(picPath, new HashMap<String, String>());
        return res.toString(2);
    }

}
