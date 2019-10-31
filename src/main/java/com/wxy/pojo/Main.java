package com.wxy.pojo;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王鑫垚
 * @version 1.0.0
 * @ClassName StartParse
 * @Description TODO
 * @createTime 2019年10月28日 17:52:00
 */
public class Main {


    public static List<String[]> main() {
        List<String[]> lists = new ArrayList<>();
        String word = "'初中高级会计报名考试系统',  '北京市财政局外网网站',  '北京通',  '北京交警APP',  '党员支持系统',  '北京市企业安全生产信息平台系统',  '北京市小客车指标调控管理信息系统升级改造项目',  '党内信息管理系统',  '北京市市属公园售票管理系统',  '政府采购系统'\n" +
                "'北京市小客车指标调控管理信息系统升级改造项目',  '北京交警APP',  '北京通',  '党员支持系统',  '初中高级会计报名考试系统',  '北京市企业安全生产信息平台系统',  '北京市市属公园售票管理系统',  '北京市财政局外网网站',  '党内信息管理系统',  '政府采购系统'\n" +
                "'北京通',  '北京市小客车指标调控管理信息系统升级改造项目…',  '北京交警APP',  '初中高级会计报名考试系统',  '党员支持系统',  '北京市企业安全生产信息平台系统',  '北京市财政局外网网站',  '北京市市属公园售票管理系统',  '政府采购系统',  '党内信息管理系统'\n" +
                "{ '北京通',  '北京交警APP',  '初中高级会计报名考试系统',  '北京市小客车指标调控管理信息系统升级改造项目…',  '北京市企业安全生产信息平台系统',  '党员支持系统',  '北京市财政局外网网站',  '政府采购系统',  '党内信息管理系统',  '石景山经信委网站'\n" +
                "'北京市小客车指标调控管理信息系统升级改造项目…',  '政府采购系统',  '初中高级会计报名考试系统',  '北京交警APP',  '北京通',  '北京市财政局外网网站',  '党员支持系统',  '北京市企业安全生产信息平台系统',  '石景山经信委网站',  '团务管理系统'\n" +
                "'政府采购系统',  '北京市小客车指标调控管理信息系统升级改造项目',  '北京通',  '初中高级会计报名考试系统',  '北京交警APP',  '北京市财政局外网网站',  '党员支持系统',  '北京市企业安全生产信息平台系统',  '党内信息管理系统',  '石景山经信委网站'\n" +
                "'北京通',  '北京市小客车指标调控管理信息系统升级改造项目',  '政府采购系统',  '北京市企业安全生产信息平台系统',  '党员支持系统',  '北京市财政局外网网站',  '北京交警APP',  '初中高级会计报名考试系统',  '党内信息管理系统',  '石景山经信委网站'\n" +
                "'北京通',  '党内信息管理系统',  '司法局首都法制宣传教育网',  '北京市企业安全生产信息平台系统',  '北京交警APP',  '北京市财政局外网网站',  '政府采购系统',  '北京市朝阳法院系统',  '全国法院网',  '北京市质量技术监督局政府网站群系统'\n" +
                "'北京通',  '党内信息管理系统',  '北京市企业安全生产信息平台系统',  '北京市财政局外网网站',  '北京国际电影节网站',  '医药产品集中采购服务平台',  '北京旅游执法检查办公系统',  '政府采购系统',  '北京交警APP',  '空间公众服务平台'\n" +
                "'党内信息管理系统',  '北京通',  '北京市企业安全生产信息平台系统',  '北京市财政局外网网站',  '北京国际电影节网站',  '北京交警APP',  '政府采购系统',  '政务办公系统',  '医药产品集中采购服务平台',  '北京市商务委门户网站'\n" +
                "'党内信息管理系统',  '北京通',  '北京市企业安全生产信息平台系统',  '北京市财政局外网网站',  '北京交警APP',  '北京市商务委门户网站',  '北京国际电影节网站',  '大数据平台',  '政府采购系统',  '全国法院网'\n" +
                "'党内信息管理系统',  '北京市财政局外网网站',  '北京通',  '北京市企业安全生产信息平台系统',  '北京共青团系统',  '北京交警APP',  '北京市商务委门户网站',  '全国法院网',  '政府采购系统',  '北京市小客车指标调控管理信息系统升级改造项目…'\n" +
                "'党内信息管理系统',  '5,646',  '北京通',  '3,210',  '北京国际电影节网站',  '2,115',  '北京市企业安全生产信息平台系统',  '1,690',  '北京市商务委门户网站',  '1,247',  '北京交警APP',  '920',  '全国法院网',  '884',  '北京市一体化在线政务服务平台',  '839',  '政府采购系统',  '831',  '党员支持系统',  '684'\n" +
                "'党内信息管理系统',  '5876',  '北京通',  '5,007',  '北京市企业安全生产信息平台系统',  '4,342',  '政府采购系统',  '1,483',  '北京市一体化在线政务服务平台',  '1,419',  '全国法院网',  '1,310',  '北京市财政局外网网站',  '1,190',  '北京交警APP',  '1,145',  '党员支持系统',  '824',  '共有产权房网上申购系统',  '799',  '0'\n" +
                "'党内信息管理系统',  '3,019',  '北京市企业安全生产信息平台系统',  '2333',  '北京通',  '2,013',  '全国法院网',  '1,448',  '北京交警APP',  '1,223',  '2019年一带一路高峰论坛注册平台',  '1,183',  '政府采购系统',  '1,032',  '北京市商务委门户网站',  '986',  '路侧停车动态监测和电子收费管理系统',  '766',  '北京市一体化在线政务服务平台',  '695'\n" +
                "'北京市企业安全生产信息平台系统',  '5,377',  '北京价格官网',  '3,263',  '北京通',  '2,632',  '全国法院网',  '2,447',  '党内信息管理系统',  '2,384',  '政府采购系统',  '1,657',  '北京交警APP',  '1,512',  '北京市质量技术监督局政府网站群系统',  '1,020',  '路侧停车动态监测和电子收费管理系统',  '984',  '广电总局业务系统',  '732'\n" +
                "'党内信息管理系统',  '5,919',  '北京通',  '3,547',  '北京市企业安全生产信息平台系统',  '3,262',  '北京价格官网',  '2,904',  '全国法院网',  '1,731',  '政府采购系统',  '1,424',  '北京市一体化在线政务服务平台',  '1,030',  '北京交警APP',  '979',  '路侧停车动态监测和电子收费管理系统',  '966',  '共有产权房网上申购系统',  '876'\n" +
                "'党内信息管理系统',  '6,640',  '北京通',  '3,657',  '北京市企业安全生产信息平台系统',  '3,378',  '北京市财政局外网网站',  '2,158',  '全国法院网',  '1,325',  '共有产权房网上申购系统',  '1,313',  '石景山经信委网站',  '1,270',  '北京交警APP',  '1,144',  '政府采购系统',  '1,120',  '北京市一体化在线政务服务平台',  '1,047'\n" +
                "'公共服务平台和业务支撑平台',  '3,620',  '党内信息管理系统',  '1,794',  '北京市小客车指标调控管理信息系统升级改造项目…',  '1,757',  '全国法院网',  '1,540',  '北京市企业安全生产信息平台系统',  '1,521',  '北京通',  '1432',  '北京交警APP',  '747',  '太极社会救助系统',  '651',  '路侧停车动态监测和电子收费管理系统',  '573',  '政府采购系统',  '566'\n" +
                "'北京市企业安全生产信息平台系统',  '1,521,199',  '全国法院网',  '1,467,599',  '北京通',  '1,284,063',  '党内信息管理系统',  '1,027,060',  '北京交警APP',  '912,639',  '北京共青团系统',  '616,731',  '政府采购系统',  '542,904',  '石景山经信委网站',  '481,713',  '北京市教委网站群',  '464,122',  '路侧停车动态监测和电子收费管理系统',  '447,430'\n" +
                "'互联网网站',  '108,763',  '北京通',  '105,848',  '健步走app',  '80,133',  '北京市总工会三级平台',  '54,342',  '政府采购系统',  '50,595',  '北京市企业安全生产信息平台系统',  '31,037',  '党员支持系统',  '29,664',  '干教网',  '24,367',  '石景山经信委网站',  '23,244',  '北京市小客车指标调控管理信息系统升级改造项目…',  '22,647'\n" +
                "'互联网网站',  '103,258',  '北京通',  '91,784',  '健步走app',  '78,921',  '北京市总工会三级平台',  '59,247',  '政府采购系统',  '48,033',  '党员支持系统',  '29,967',  '北京市企业安全生产信息平台系统',  '29,962',  '石景山经信委网站',  '26,093',  '干教网',  '24,796',  '北京市小客车指标调控管理信息系统升级改造项目…',  '21,910'\n" +
                "'健步走app',  '81,143',  '北京通',  '54,725',  '北京市总工会三级平台',  '41,666',  '政府采购系统',  '31,168',  '互联网网站',  '29,309',  '干教网',  '26,813',  '北京市企业安全生产信息平台系统',  '21,501',  '北京市财政局外网网站',  '18,316',  '组工网',  '18,122',  '党员支持系统',  '16924'";
        String[] ss = word.split("\n");
        for (String s : ss) {
            String[] a = s.split(",  ");
            lists.add(a);
        }
        return lists;
    }
}
