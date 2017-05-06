package com.lubao.forbackend.service;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.CommentMix;
import com.lubao.forbackend.domain.CommentTable;

@Service
public interface CommentService {
    public CommentTable[] getCommentTablesByID(int cid);//根据cid获得评论
    public CommentTable[] getCommentTablesByNid(int nid);//获得作者的所有评论
    public int insertComment(CommentTable commentTable);//插入话题
    public CommentMix[] getCommentMixsByID(int cid);//根据cid获得评论和评论人的混合信息
}
