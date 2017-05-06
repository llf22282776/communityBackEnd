package com.lubao.forbackend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.dao.PersonalDAO;
import com.lubao.forbackend.domain.CommentMix_2;
import com.lubao.forbackend.domain.PersonalTable;

@Service
public class PersonalServiceImp implements PersonalService{
    @Resource
    PersonalDAO personalDAO;
    
    @Override
    public PersonalTable getPersonMsgById(int nid) {
        // TODO Auto-generated method stub
      
        return personalDAO.getPersonMsgById(nid);
    }

    @Override
    public int setMsgViewed(int[] cids, int[] nids) {
        // TODO Auto-generated method stub
        int nums=0;
        for(int i=0;i<cids.length;i++){
             int cid=cids[i];
             int nid=nids[i];
             System.out.println("nid:"+nid+" "+"cid:"+cid);
             nums+=personalDAO.setMsgViewed(nid, cid);
            
        }
        return nums;
    }

    @Override
    public CommentMix_2[] getMsgNew(int nid) {
        // TODO Auto-generated method stub
        return personalDAO.getMsgNew(nid);
    }

    @Override
    public int getNewsMsgNums(int nid) {
        // TODO Auto-generated method stub
        return personalDAO.getMsgNewNums(nid);
    }

    @Override
    public PersonalTable Login(String passPort, String pwd) {
        // TODO Auto-generated method stub
         
     
        return    personalDAO.Login(passPort, pwd);
    }
    
    

}
