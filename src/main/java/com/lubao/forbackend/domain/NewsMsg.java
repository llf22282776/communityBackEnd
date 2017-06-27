package com.lubao.forbackend.domain;

import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class NewsMsg implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String title;
    private String content;
    private String url;
    private String img;
    private String medId;
    
    
    
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getMedId() {
        return medId;
    }
    public void setMedId(String medId) {
        this.medId = medId;
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
