package com.lubao.forbackend.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;







import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lubao.forbackend.service.SpiderService;

@Controller
public class CrawlControl {
    
    @Resource
    public SpiderService spiderService ;
    
    
    @RequestMapping(value = "api/crawler/StartCrawler", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String startCrawl(@RequestParam("pageNum") int pageNum){
        
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以 
        String ipAddress="localhost";
        String port="8888";
        System.getProperties().setProperty("http.proxyHost", ipAddress);
        System.getProperties().setProperty("http.proxyPort", port);
        spiderService.setPagNums(pageNum);
        spiderService.start();//启动进程;
        
        return "Started!!";
      
        
        
        
        
    }
    @RequestMapping(value = "crawler/crawlNews", method = {
            RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public JSONObject crawlNews(@RequestParam("medName") String medName){
        System.out.println("正在搜索新闻");
      JSONObject jsonObject;
    try {
        jsonObject = spiderService.crawlNews(medName);
        if(jsonObject == null){
            JSONObject jsonObj= new JSONObject();
            jsonObj.put("list", new JSONArray());
            return jsonObj;
        }
        return jsonObject;
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        JSONObject jsonObj= new JSONObject();
        jsonObj.put("list", new JSONArray());
        return jsonObj;
      
    }
        
    }
    

}
