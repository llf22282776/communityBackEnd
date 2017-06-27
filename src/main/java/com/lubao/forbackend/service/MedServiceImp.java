package com.lubao.forbackend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.dao.MedDao;
import com.lubao.forbackend.domain.MedMsg;
@Service
public class MedServiceImp implements MedService{

    @Resource
    private MedDao medDao;
    
    @Override
    public boolean insertMedMsg(MedMsg medMsg) {
        // TODO Auto-generated method stub
        
        return medDao.insertMed(medMsg) >= 1 ? true:false;
    }

    @Override
    public MedMsg getMedMsg(String medIdString) {
        // TODO Auto-generated method stub
        return medDao.getMedMsg(medIdString);
    }

    @Override
    public int getMedMsgNums(String medIdString) {
        // TODO Auto-generated method stub
        return medDao.getNumsByMedID(medIdString);
    }

    
    
}
