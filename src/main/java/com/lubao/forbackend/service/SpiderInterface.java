package com.lubao.forbackend.service;

import java.io.IOException;

import org.apache.commons.validator.Msg;
import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.MedMsg;
import com.lubao.forbackend.domain.NewsMsg;
@Service
public interface SpiderInterface {
    //爬虫通用
    //将基本信息保存到基本表
    

    //根据药品名字爬取图片
    public String[] crawlMedPics(String medId);//获取图片链接地址
    public String[] savePics(String[] pics,String medId,int type);//保存图片，返回图片本地名字,根据type到不同的文件夹
    
    public NewsMsg[] crawlNews(String[] medNames,String[] medId);//根据药品名字或Id，获得新闻链接,新闻图片地址，新闻图片标题

    public String[] crawlMedIndexId(int pageNum) throws IOException;//根据页数，获取药品的下标编号
    public MedMsg crawlMedMsg(String medIndexId);//获取药品批准文号
    
}
