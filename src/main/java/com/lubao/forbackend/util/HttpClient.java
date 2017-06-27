package com.lubao.forbackend.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;




















import javax.annotation.Resource;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import antlr.collections.List;

import com.lubao.forbackend.domain.MedMsg;
import com.lubao.forbackend.domain.NewsMsg;
@Service
public class HttpClient {
    //用来发送post/get请求

    //获得药品页面的的String串
    public static final int MAX_TIMEOUT=15000;
    public static Document  POST_TO_GET_PAGE_HTML(int pageNum,Map<String, String> headerMap,Map<String, String> formMap) throws IOException {
        formMap.put("curstart", pageNum+"");
        
        return Jsoup.parse(HttpClient.POST(headerMap, formMap, Constant.PAGE_URL)); //返回的是字符串，里面用正则去过滤

     
    }
    //获得的药品详情的dom树,是indexId
    public static Document  POST_TO_GET_MED_HTML(String medIndexId ,Map<String, String> hearMap) {
        String completedUrl  = Constant.DETAIL_BASE+medIndexId;
        return HttpClient.GET_DOCUMENT(hearMap, completedUrl);
        
        
        
        
     
    }
    //获得新闻的String串
    public static java.util.List<NewsMsg>  POST_TO_GET_NEWS_HTML(Map<String, String> hearMap,String medName,String typeKey) throws UnsupportedEncodingException {
        String completeStr=String.format(Constant.NEWS_BASE,medName+" "+typeKey)+Constant.NEWS_BASE2;
        Document document= HttpClient.GET_DOCUMENT_1(Constant.HEADER_MAP_NEWS, completeStr);//
        java.util.List<NewsMsg> newsList=new ArrayList<NewsMsg>();
        if(document == null )return null;
        Elements h3Elements=document.getElementsByClass("t");//
        
        for(int i=0;i<h3Elements.size();i++){
            NewsMsg newsMsg= new NewsMsg();
            Element element=h3Elements.get(i);
            Element aElement= element.getElementsByTag("a").get(0);
            
            newsMsg.setTitle(aElement.text());
            System.out.println(aElement.text());
            newsMsg.setUrl(aElement.attr("href"));
            newsList.add(newsMsg);
        }


        return (java.util.List<NewsMsg>) newsList;
        
    }
  //获得的药品图片所在的网页dom树,药品批准文号
    public static Document  GET_TO_GET_MED_PIC_HTML(String medId,Map<String, String> headerMap) {
        return HttpClient.GET_DOCUMENT(headerMap, Constant.IMG_CRAWL_URL+medId);//图片
        
    }
    
    
    //读取图片并保存,返回路径,失败返回null
    public static String OPEN_IMG_SAVE(String urlStr,String medId,int index) {
        try {
            URL url = new URL(urlStr.replaceAll("t.jpg", ".jpg"));  
            //打开链接  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            //设置请求方式为"GET"  
            conn.setRequestMethod("GET");  
            //超时响应时间为5秒  
            conn.setConnectTimeout(HttpClient.MAX_TIMEOUT);  
            //通过输入流获取图片数据  
            InputStream inStream = conn.getInputStream();  
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
           
            ByteArrayOutputStream outStream1 = new ByteArrayOutputStream();  
            //创建一个Buffer字符串  
            
            //每次读取的字符串长度，如果为-1，代表全部读取完毕  
            int len = 0;  
            //使用一个输入流从buffer里把数据读取出来  
            byte[] buffer=new byte[1024];
            while( (len=inStream.read(buffer)) != -1 ){  
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
                outStream1.write(buffer, 0, len);  
            }  
            //关闭输入流  
            byte[] data= outStream1.toByteArray();
            inStream.close();  
            //把outStream里的数据写入内存  
            
            //new一个文件对象用来保存图片，默认保存当前工程根目录  
            System.out.println("文件名:"+Constant.WEB_ROOT+Constant.MED_IMG_ROOT+medId+"_"+index+".jpg");
            File imageFile = new File(Constant.WEB_ROOT+Constant.MED_IMG_ROOT+medId+"_"+index+".jpg");  
          
            if(imageFile.exists()){imageFile.delete();imageFile.createNewFile();}
            else imageFile.createNewFile();
            //创建输出流  
            FileOutputStream outStream = new FileOutputStream(imageFile);  
            //写入数据  
            outStream.write(data);  
            //关闭输出流  
            outStream.close();  
            return imageFile.getName();//返回名字
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "";//失败返回""
        }
        
        
        
        
    }
    //原子post方法
    public static String  POST(Map<String, String> headerMap,Map<String, String> formMap,String url) throws IOException {
        
        Connection connection=Jsoup.connect(url);//
        //connection=connection.cookies(Constant.COOKIES);
        Set<Entry<String , String>> set=headerMap.entrySet();
        for(Entry<String, String> entry:set){
            
            connection.header(entry.getKey(), entry.getValue());//设置头
        }
        
        connection.data(formMap);//设置请求数据
        try {
            Response res=connection.ignoreContentType(true).timeout(HttpClient.MAX_TIMEOUT).method(Method.POST).execute();
            return res.body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            HttpClient.changeProxy();
            System.out.println("url:"+url);
            System.out.println("curstart:"+formMap.get("curstart"));
            
            throw e;
            
            
            
        }
        
    }
    //原子get方法
    public static String  GET(Map<String, String> headerMap,String url) {
        Connection connection=Jsoup.connect(url);//
        //connection=connection.cookies(Constant.COOKIES);
        Set<Entry<String , String>> set=headerMap.entrySet();
        for(Entry<String, String> entry:set){
            connection.header(entry.getKey(), entry.getValue());//设置头
        }
      
        try {
            Response res=connection.timeout(HttpClient.MAX_TIMEOUT).method(Method.GET).execute();
            return res.body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            HttpClient.changeProxy();
            e.printStackTrace();
            return "";
            
            
        }
        
        
      
    }
    //原子post方法,DOCUMENT
    public static Document  POST_DOCUMENT(Map<String, String> headerMap,Map<String, String> formMap,String url) {
        Connection connection=Jsoup.connect(url);//
        //connection=connection.cookies(Constant.COOKIES);
        Set<Entry<String , String>> set=headerMap.entrySet();
        for(Entry<String, String> entry:set){
            connection.header(entry.getKey(), entry.getValue());//设置头
        }
        connection.data(formMap);//设置请求数据
        try {
            Response res=connection.timeout(HttpClient.MAX_TIMEOUT).method(Method.POST).execute();
            return Jsoup.parse(res.body());
        } catch (IOException e) {
            // TODO Auto-generated catch block
           HttpClient.changeProxy();
            e.printStackTrace();
            //切换节点
     
            return null;
            
            
        }
       
    }
    
    //原子get方法,DOCUMENT
    public static Document  GET_DOCUMENT(Map<String, String> headerMap,String url) {
        Connection connection=Jsoup.connect(url);//
        //connection=connection.cookies(Constant.COOKIES);
        Set<Entry<String , String>> set=headerMap.entrySet();
        for(Entry<String, String> entry:set){
            connection.header(entry.getKey(), entry.getValue());//设置头
        }
     
        try {
            Response res=connection.timeout(HttpClient.MAX_TIMEOUT).method(Method.GET).execute();
            
            return Jsoup.parse(res.body());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("GET url:"+url);
            HttpClient.changeProxy();
            e.printStackTrace();
            return null;
            
            
        }
    }
  //原子get方法,DOCUMENT
    @SuppressWarnings("unchecked")
    public static Document  GET_DOCUMENT_1(Map<String, String> headerMap,String url) {
        
        
        
        
        Connection connection=Jsoup.connect(url);//
        //connection=connection.cookies(Constant.COOKIES);
        
        
        
        Set<Entry<String , String>> set=headerMap.entrySet();
        for(Entry<String, String> entry:set){
            connection.header(entry.getKey(), entry.getValue());//设置头
        }
        @SuppressWarnings("rawtypes")
        Map coMap=HttpClient.getCookies(Constant.BAIDU_);
        if(coMap != null)connection.cookies(coMap);
        
     
        try {
            Response res=connection.timeout(HttpClient.MAX_TIMEOUT).method(Method.GET).execute();
            
            return Jsoup.parse(res.body());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("GET url:"+url);
            HttpClient.changeProxy();
            e.printStackTrace();
            return null;
            
            
        }
    }
    public static Map<String, String> getCookies(String url){
        
        Connection connection=Jsoup.connect(url);//
        try {
           Response response  = connection.ignoreContentType(true).timeout(HttpClient.MAX_TIMEOUT).execute();
           Map<String, String > cookiesMap= response.cookies();
           return cookiesMap;
           
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return null;
        }
          
    }
   
    public static void changeProxy() {
        System.out.println("正在切换节点");
        Random random=new Random();
        int max=Constant.dyncProxy.length-1;
        int min=0;
        int numsRandom=random.nextInt(max)%(max-min+1) + min;
        String ipAddress=Constant.dyncProxy[numsRandom][0];
        String port=Constant.dyncProxy[numsRandom][1];
        System.out.println("新节点的ip："+ipAddress+"端口为:"+port);
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以 
        
        System.getProperties().setProperty("http.proxyHost", ipAddress);
        System.getProperties().setProperty("http.proxyPort", port);
        
    }
    public static void changeProxyNew() {
        System.out.println("正在切换节点");
        
        
        Random random=new Random();
        int max=Constant.dyncProxy.length-1;
        int min=0;
        int numsRandom=random.nextInt(max)%(max-min+1) + min;
        String ipAddress=Constant.dyncProxy[numsRandom][0];
        String port=Constant.dyncProxy[numsRandom][1];
        System.out.println("新节点的ip："+ipAddress+"端口为:"+port);
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以 
        
        System.getProperties().setProperty("http.proxyHost", ipAddress);
        System.getProperties().setProperty("http.proxyPort", port);
        
    }
}
