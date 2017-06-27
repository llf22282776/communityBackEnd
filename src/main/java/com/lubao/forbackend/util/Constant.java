package com.lubao.forbackend.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.context.support.StaticApplicationContext;

public class Constant {
    public static String coversionRootString = "/static/images/";
    public static String personalRootString = "/static/images/";
    public static String WEB_ROOT="E:\\tools\\apache-tomcat-7.0.72\\ServersDir\\DACH_lubao\\wtpwebapps\\forwardbackend\\WEB-INF";
    public static String MED_IMG_ROOT = "/static/images/medImage/";// 保存图片的文件夹
    public static final int SUPPORT = 1; // 点赞
    public static final int UNSUPPORT = 2; // 取消点赞
    public static final String IMG_END="t.jpg";//图片后缀
    public static final String KEY_NEWS_1="问题";
    public static final String KEY_NEWS_2="事故";
    public static final String IMG_CRAWL_URL = "https://www.315jiage.cn/search.aspx?where=certification&keyword=";// 根据国药准字爬取
    public static final String PAGE_URL = "http://app1.sfda.gov.cn/datasearch/face3/search.jsp";// 爬取的每页目录
    public static final String DETAIL_BASE = "http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=25&tableName=TABLE25&tableView=国产药品&Id=";// id在这里,去替换掉就行
    public static final String REX_IDSTRING = "&Id=.*'";// 匹配id
    public static final String REX_IDSTRING_BASE = "&Id";// 前缀字符串
    public static final String IMG_ROOT="https://www.315jiage.cn/";//图片元素跟地址
    public static final Pattern medIdPattern = Pattern.compile("&Id=*'");
    public static final String NEWS_BASE="https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%s";
    public static final String NEWS_BASE1="&rsv_pq=&rsv_t=";//新闻基本字符串
    public static final String NEWS_BASE2="&rqlang=cn&rsv_enter=1&rsv_sug3=4&rsv_sug2=0&inputT=1380&rsv_sug4=1545";
    public static final String BAIDU_="http://www.baidu.com";
    
    public static final Map<String, String> HEADER_MAP = new HashMap<String, String>() {
        {
            put("Host", "app1.sfda.gov.cn");
            put("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
            put("Accept", "*/*");
            put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            put("Cache-Control", "no-cache");
            put("Accept-Encoding", "gzip, deflate");
            put("Content-Type", "application/x-www-form-urlencoded");
            put("Referer",
                    "http://app1.sfda.gov.cn/datasearch/face3/base.jsp?tableId=25&tableName=TABLE25&title=%B9%FA%B2%FA%D2%A9%C6%B7&bcId=124356560303886909015737447882");
            put("Content-Length", "273");
            put("cookies", "JSESSIONID=C20E52A59C5912E809AEEC4F1F9E1DC1.7; yunsuo_session_verify=d80aaa19187a7e2606a0426cf5f067f9; _gscu_1586185021=89115054w77dim11; _gscu_1358151024=89115556e048p161; yunsuo_session_verify=2e8421e43923d189e78fec093e55d37d; _gscs_1586185021=t95051452qhh8mo88|pv:10; _gscbrs_1586185021=1");
            put("Connection", "keep-alive");
        }
    };
    public static final Map<String, String> HEADER_MAP_NEWS = new HashMap<String, String>() {
        {
            put("Host", "www.baidu.com");
            put("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
            put("Accept", "*/*");
            put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            put("Cache-Control", "no-cache");
            put("Accept-Encoding", "gzip, deflate");
            put("Content-Type", "application/x-www-form-urlencoded");
                        put("Content-Length", "273");
            put("cookies", "BD_UPN=13314752; BDUSS=zFNZ0E3STZJSk4zUXMyZFp5R293NGhzN1ktai1CeGVrY1Z6cjNzYWZPNWhzUzlaSVFBQUFBJCQAAAAAAAAAAAEAAABukXpBY2FyYm9ubGVzc2x5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGEkCFlhJAhZY; ispeed_lsm=2; BAIDUID=656BEB2B6F1947412F96BEE0709F4021:FG=1; BIDUPSID=1D8E8C36CAFB33DB0508E5E6ADADD036; PSTM=1494695481; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_PSSID=1446_21118_21670_20930; H_PS_645EC=e78ele2rxku0Nl%2BKeo33FHivig6lUDpRq%2F7DXaR3%2BgrhmYCMDmhbzx5sRwn2Ixh7Vor9; BD_CK_SAM=1; PSINO=1; BD_HOME=1; BDRCVFR[gltLrB7qNCt]=mk3SLVN4HKm; sug=3; sugstore=1; ORIGIN=2; bdime=0; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; __bsi=11219255991261339611_00_0_I_R_289_0303_C02F_N_I_I_0");
            put("Connection", "keep-alive");
            put("Upgrade-Insecure-Requests", "1");
        }
    };
    public static final Map<String, String> HEADER_MAP_IMG = new HashMap<String, String>() {
        {
            put("Host", "www.315jiage.cn");
            put("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
            put("Accept", "*/*");
            put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            put("Cache-Control", "no-cache");
            put("Accept-Encoding", "gzip, deflate");
            put("Content-Type", "application/x-www-form-urlencoded");
            put("Referer",
                    "https://www.315jiage.cn/search.aspx?where=title&keyword=asd");
            put("cookies","__cfduid=d4004f0cbedf921a8be417742f8b121fd1495037161; Hm_lvt_4cce664ec5d8326cc457ab09053c15b2=1495037165; Hm_lpvt_4cce664ec5d8326cc457ab09053c15b2=1495039428");
            put("Content-Length", "273");

            put("Connection", "keep-alive");
        }
    };
    public static final Map<String, String> COOKIES = new HashMap<String, String>() {
        {

            put("JSESSIONID", "FA71E64631C95720718029C6FDD9770F.7");

            put("_gscu_1586185021", "FA71E64631C95720718029C6FDD9770F.7");

            put("_gscu_1358151024", "FA71E64631C95720718029C6FDD9770F.7");
            put("yunsuo_session_verify", "FA71E64631C95720718029C6FDD9770F.7");

            put("_gscs_1586185021", "94987612fkb7oj31|pv:4");
            put("_gscbrs_1586185021", "1");

        }

    };
    public static final String[][] dyncProxy=new String[][]{
        new String[]{"115.231.175.68","808"},
        new String[]{"115.220.7.57","808"},
        new String[]{"180.76.154.5","8888"},
        new String[]{"222.85.39.123","808"},
        new String[]{"219.136.172.132","9797"},
        new String[]{"114.239.147.152","808"},
        new String[]{"175.155.24.28","808"},
        new String[]{"115.196.22.164","8118"},
        new String[]{"115.231.175.68","8081"},
        new String[]{"119.5.0.59","808"},

    };
    
    
//        119.5.1.54  808     四川南充    高匿  HTTP    78天     2分钟前
//    Cn  115.220.7.57    808     浙江宁波    高匿  HTTP    2小时     3分钟前
//    Cn  180.76.154.5    8888    北京  高匿  HTTP    82天     3分钟前
//    Cn  182.38.172.68   8118    山东滨州    高匿  HTTP    14小时    4分钟前
//    Cn  219.136.172.132     9797    广东广州市海珠区    透明  HTTP    5小时     4分钟前
//    Cn  114.239.147.152     808     江苏宿迁市泗阳县    高匿  HTTP    5天  4分钟前
//    Cn  175.155.24.28   808     四川德阳    高匿  HTTP    79天     4分钟前
//    Cn  115.196.22.164  8118    浙江杭州    高匿  HTTP    21小时    4分钟前
//    Cn  58.209.151.126  808     江苏苏州    高匿  HTTP    21小时    4分钟前
//    Cn  116.226.90.12   808     上海  高匿  HTTP    8天  4分钟前
//    Cn  124.207.126.15  808     北京  透明  HTTP    12小时    4分钟前
//    Cn  61.191.41.130   80  安徽合肥    透明  HTTP    57天     4分钟前
//    Cn  115.231.175.68  8081    浙江杭州    透明  HTTP    134天    4分钟前
//    Cn  112.87.92.166   8118    江苏宿迁    高匿  HTTP    1天  5分钟前
//    Cn  118.254.126.56  808     湖南张家界   高匿  HTTP    12小时    5分钟前
//    Cn  119.5.0.59  808     四川南充    高匿  HTTP    74天     5分钟前
//    Cn  119.5.0.14  808     四川南充    高匿  HTTP    70天     5分钟前
//    Cn  119.5.0.28  808     四川南充    高匿  HTTP    75天     9分钟前
//    Cn  210.76.163.216  8118    辽宁大连    透明  HTTP    17天     9分钟前
//    Cn  222.85.39.123   808     河南平顶山   高匿  HTTP    51天     12分钟前
    public static final Map<String, String> FORM_MAP = new HashMap<String, String>() {
        {
            put("tableId", "25");
            put("State", "1");
            put("bcId", "124356560303886909015737447882");
            put("tableName", "TABLE25");
            put("viewtitleName", "COLUMN167");
            put("viewsubTitleName", "COLUMN821,COLUMN166,COLUMN170&State=1");
            put("curstart", "2");// 这个第几页用就第几页用
            put("tableView",
                    "%25E5%259B%25BD%25E4%25BA%25A7%25E8%258D%25AF%25E5%2593%2581");

        }
    };

}
