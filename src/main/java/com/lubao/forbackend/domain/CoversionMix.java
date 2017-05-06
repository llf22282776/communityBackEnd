package com.lubao.forbackend.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class CoversionMix implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public int getNid() {
        return nid;
    }
    public void setNid(int nid) {
        this.nid = nid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getSupportNum() {
        return supportNum;
    }
    public void setSupportNum(int supportNum) {
        this.supportNum = supportNum;
    }
    public int getCommentNum() {
        return commentNum;
    }
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
 
    private int cid;
    private int nid;
    private String title;
    private String content;
    private int supportNum;
    private int commentNum;
    private Timestamp date;
    private String nick;
    private String imageUrl;
    private String thumbnail;
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    
    
    
}
