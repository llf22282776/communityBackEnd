package com.lubao.forbackend.service;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.MedMsg;
@Service
public interface MedService {
    public boolean insertMedMsg(MedMsg medMsg);//插入一个药品
    public MedMsg getMedMsg(String medIdString);//获得一个药品
    public int getMedMsgNums(String medIdString);//获得一个药品
}
