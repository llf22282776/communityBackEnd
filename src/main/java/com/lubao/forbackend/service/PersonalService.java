package com.lubao.forbackend.service;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.CommentMix_2;
import com.lubao.forbackend.domain.PersonalTable;

@Service
public interface PersonalService {
    public PersonalTable getPersonMsgById(int nid); //获得个人消息
    
    public int setMsgViewed(int[] cids,int[] nids  );//将某个人的消息设置为true
    public CommentMix_2[] getMsgNew(int nid);//获得一个人的新消息
    public int getNewsMsgNums(int nid);//获得一个人的新消息数量
    public PersonalTable Login(String passPort,String pwd);//登陆
    
}
