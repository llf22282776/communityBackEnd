package com.lubao.forbackend.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HttpSessionMutexListener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lubao.forbackend.domain.MedMsg;
import com.lubao.forbackend.domain.NewsMsg;
import com.lubao.forbackend.util.Constant;
import com.lubao.forbackend.util.HttpClient;

@Service
public class SpiderService extends Thread implements SpiderInterface {
    @Resource
    private MedService medServiceImp;
    private int pagNums;
    @Override
    public String[] crawlMedPics(String medId) {
        // TODO Auto-generated method stub
        // 这里返回的是一个药品的图片原始图片链接，用,隔开
        List<String> imgsList = new ArrayList<>();
        Document document = HttpClient.GET_TO_GET_MED_PIC_HTML(medId,
                Constant.HEADER_MAP_IMG);
        if (document != null) {
            Elements elements = document.getElementsByClass("thumbnail");// 这是图片
            for (int i = 0; i < elements.size(); i++) {
                imgsList.add(Constant.IMG_ROOT + (elements.get(i)).attr("src"));
            }
        }

        return listToStringd(imgsList);// 返回字符串数组
    }

    @Override
    public String[] savePics(String[] pics, String medId, int type) {
        // TODO Auto-generated method stub
        if (type == 0) {
            System.out.println("pic == null:"+pics==null);
            if (pics == null)
                return null;
            List<String> imgsList = new ArrayList<>();
            for (int i = 0; i < pics.length; i++) {
                imgsList.add(HttpClient.OPEN_IMG_SAVE(pics[i], medId, i));
            }
            return listToStringd(imgsList);// 返回字符串数组

        } else {

            return null;
        }
    }

    @Override
    public NewsMsg[] crawlNews(String[] medNames, String[] medId) {
        // TODO Auto-generated method stub
        for(String medName:medNames ){
            
            
            
            
            
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public JSONObject crawlNews(String medName) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
      
       List<NewsMsg> list1= (List<NewsMsg>) HttpClient.POST_TO_GET_NEWS_HTML(Constant.HEADER_MAP_NEWS, medName, Constant.KEY_NEWS_1);
       List<NewsMsg> list2= (List<NewsMsg>) HttpClient.POST_TO_GET_NEWS_HTML(Constant.HEADER_MAP_NEWS, medName, Constant.KEY_NEWS_2);
       JSONObject jsonObject=new JSONObject();
       JSONArray jsonArray=new JSONArray();
       System.out.println("size!!!!!"+" "+list1.size()+" "+list2.size());
       for(NewsMsg newsMsg:list1){
           JSONObject jsonObject2=new JSONObject();
           jsonObject2.put("title", newsMsg.getTitle());
           jsonObject2.put("url", newsMsg.getUrl());
           jsonObject2.put("date",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
           .format(new Date())); 
           jsonArray.add(jsonObject2);
           
           
       }
       for(NewsMsg newsMsg:list2){
           JSONObject jsonObject2=new JSONObject();
           jsonObject2.put("title", newsMsg.getTitle());
           jsonObject2.put("url", newsMsg.getUrl());
           jsonObject2.put("date",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
           .format(new Date())); 
           jsonArray.add(jsonObject2);
           
           
       }

         jsonObject.put("list", jsonArray);
         return jsonObject;
    }
    
    @Override
    public String[] crawlMedIndexId(int pageNum) throws IOException{
        // TODO Auto-generated method stub
        List<String> medIndexidList = new ArrayList<>();
        Document document = HttpClient.POST_TO_GET_PAGE_HTML(pageNum,
                Constant.HEADER_MAP, Constant.FORM_MAP);
        if(document == null)return null;
        Elements aElements=document.getElementsByTag("a");
        
        for(int i=0;i<aElements.size();i++){
            Element element=aElements.get(i);
            String string=element.attr("href");
            System.out.println();
            if(string.startsWith("javascript:commitForECMA(callbackC,")){
                String medindexString=string.substring(string.indexOf("&Id=")+"&Id=".length(),string.indexOf("',"));
                medIndexidList.add(medindexString);
                System.out.println("medIndex为："+medindexString);
            }
            
        }
        
      
        return listToStringd(medIndexidList);
    }
    private String[] listToStringd(List<String> list){
        String[] strings=new String[list.size()];
        for(int i=0;i<list.size();i++){
            strings[i]=list.get(i);
            
        }
        return strings;
        
    }
    @Override
    public void run() {
        int MAX_PAGE_NUM = 11000;
        
            int i = pagNums;
            while (i <= MAX_PAGE_NUM) {
                try {
                    System.out.println("开始爬取第"+i+"页");
                    String[] medIndexs = this.crawlMedIndexId(i);
                   System.out.println("medIndex的数量是:"+medIndexs.length);
                    int k=0;//尝试三次
                    for (int j = 0; j < medIndexs.length; ) {
                        
                        try {
                            System.out.println("开始爬取索引id为:"+medIndexs[j]);
                            MedMsg msg = crawlMedMsg(medIndexs[j]);
                            if (medServiceImp.getMedMsgNums(msg.getMedId()) == 0)
                                {  
                                
                                this.printMedMsg(msg);
                                medServiceImp.insertMedMsg(msg);
                                }
                            else{
                                System.out.println("药品id为"+msg.getMedId()+"的药品已有");
                            }
                            j++;
                        } catch (Exception e) {
                            // TODO: handle exception
                            
                            if(k<3)k++;
                            else {j++;k=0;}
                            System.out.println("爬取第" + j + "个药品出错");
                            e.printStackTrace();
                            
                        }finally{
                            //Thread.sleep(3000);
                        }
                    }
                    Thread.sleep(1000);
                    i++;
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("爬取第" + i + "页出错");// 重新爬
                }

            }
            return;
        

    }

    @Override
    public MedMsg crawlMedMsg(String medIndexId) {
        // TODO Auto-generated method stub
        //
        MedMsg msg = new MedMsg();
        Document document = HttpClient.POST_TO_GET_MED_HTML(medIndexId,
                Constant.HEADER_MAP);
        if(document == null)return null;
        Elements elements = document.getElementsByTag("tr");
        
        for (int i = 1; i < elements.size() && i <= 12; i++) {
            String key = elements.get(i).getElementsByTag("td").get(0).text()
                    .trim();
            String value = elements.get(i).getElementsByTag("td").get(1).text()
                    .trim();
            if (key.equals("批准文号")) {
                String[] imgs = this.savePics(this.crawlMedPics(value), value,
                        0);// 保存图片
                String img = "";
                for (String imgStr : imgs) {
                    img += imgStr + ";";
                }
                
                fillMedMsg(msg, "图片", img);
                fillMedMsg(msg, key, value);// 填进去
            } else {
                fillMedMsg(msg, key, value);// 填进去
            }
        }
        return msg;
    }
    public void printMedMsg(MedMsg medMsg){
        System.out.println("----药品信息---");
        System.out.println("批准文号"+ medMsg.getMedId());
        System.out.println("产品名称"+medMsg.getMedName());
        System.out.println("英文名称"+medMsg.getMedName_f());
        System.out.println("商品名"+ medMsg.getMedNmae_p());
        System.out.println("剂型"+ medMsg.getMedJuice());
        System.out.println("规格"+  medMsg.getMedStruct());
        System.out.println("生产单位"+ medMsg.getMedUnit());
        System.out.println("生产地址"+medMsg.getMedDet());
        System.out.println("产品类别"+medMsg.getMedClass());
        System.out.println("批准日期"+ medMsg.getMedDate());
        System.out.println("原批准文号"+medMsg.getMed_before());
        System.out.println("药品本位码"+ medMsg.getMedPositionSeq());
        System.out.println("图片"+medMsg.getImg());

        
        
    }
    private boolean fillMedMsg(MedMsg medMsg, String key, String value) {
        if (key.equals("批准文号")) {
            medMsg.setMedId(value);
            return true;
        }
        if (key.equals("产品名称")) {
            medMsg.setMedName(value);
            return true;
        }
        if (key.equals("英文名称")) {
            medMsg.setMedName_f(value);
            return true;
        }
        if (key.equals("商品名")) {
            medMsg.setMedNmae_p(value);
            ;
            return true;
        }
        if (key.equals("剂型")) {
            medMsg.setMedJuice(value);
            return true;
        }
        if (key.equals("规格")) {
            medMsg.setMedStruct(value);
            return true;
        }
        if (key.equals("生产单位")) {
            medMsg.setMedUnit(value);
            return true;
        }
        if (key.equals("生产地址")) {
            medMsg.setMedDet(value);
            return true;
        }
        if (key.equals("产品类别")) {
            medMsg.setMedClass(value);
            return true;
        }
        if (key.equals("批准日期")) {
            medMsg.setMedDate(value);
            return true;
        }
        if (key.equals("原批准文号")) {
            medMsg.setMed_before(value);
            return true;
        }
        if (key.equals("药品本位码")) {
            medMsg.setMedPositionSeq(value);
            return true;
        }
        if (key.equals("图片")) {
            medMsg.setImg(value);
            return true;
        }
        return false;

    }

    public int getPagNums() {
        return pagNums;
    }

    public void setPagNums(int pagNums) {
        this.pagNums = pagNums;
    }

}
