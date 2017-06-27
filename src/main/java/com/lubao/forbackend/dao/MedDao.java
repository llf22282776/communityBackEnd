package com.lubao.forbackend.dao;


import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.MedMsg;
@Service
public interface MedDao {
    public int getNumsByMedID(String MedId);//获取某个药品的数量
    public int insertMed(MedMsg medMsg);//插入一个药品
    public MedMsg getMedMsg(String medId);//根据medId获得一个药品
    
    
    
    //新闻的就放在前端吧
}
