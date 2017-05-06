package com.lubao.forbackend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.dao.CommentDAO;
import com.lubao.forbackend.domain.CommentMix;
import com.lubao.forbackend.domain.CommentTable;

@Service
public class CommentServiceImp implements CommentService{

    @Resource
    private CommentDAO commentDAO;
    
    @Override
    public CommentTable[] getCommentTablesByID(int cid) {
        // TODO Auto-generated method stub
        return commentDAO.getCommentTablesByID(cid);

    }

    @Override
    public CommentTable[] getCommentTablesByNid(int nid) {
        // TODO Auto-generated method stub
        return commentDAO.getCommentTablesByID(nid);
    }

    @Override
    public int insertComment(CommentTable commentTable) {
        // TODO Auto-generated method stub
        commentTable.setState(0);
        return commentDAO.insertComment(commentTable);
    }

    @Override
    public CommentMix[] getCommentMixsByID(int cid) {
        // TODO Auto-generated method stub
        return commentDAO.getCommentMixsByID(cid);
    }

}
