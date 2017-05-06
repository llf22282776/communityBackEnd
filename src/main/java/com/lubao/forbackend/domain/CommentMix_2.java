package com.lubao.forbackend.domain;

import java.sql.Timestamp;

public class CommentMix_2 {
    private String coversionTitle;
    
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getCoversionTitle() {
        return coversionTitle;
    }
    public void setCoversionTitle(String coversionTitle) {
        this.coversionTitle = coversionTitle;
    }
    private int cid;
    private int nid;
    private String content;
    private Timestamp date;
    private String nick;
    private String thumbnail;
}
