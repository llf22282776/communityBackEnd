package com.lubao.forbackend.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


import com.lubao.forbackend.domain.CommentMix_2;
import com.lubao.forbackend.domain.PersonalTable;

@Service
public interface PersonalDAO {
    public PersonalTable getPersonMsgById(int nid);//查人信息
    public CommentMix_2[] getMsgNew(int nid);//查看个人新的消息
    public int setMsgViewed(int nid,int cid);//将消息设置为已查看
    public int getMsgNewNums(int nid);//查看个人消息的数量
}
