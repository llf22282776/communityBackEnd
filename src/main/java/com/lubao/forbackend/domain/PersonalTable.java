package com.lubao.forbackend.domain;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class PersonalTable implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int nid;
    private String nick;
    private byte sex;
    private String thumbnail;
    private String passPort;
    private String pwd;
    private String phone;
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassPort() {
        return passPort;
    }
    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public int getNid() {
        return nid;
    }
    public void setNid(int nid) {
        this.nid = nid;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public byte getSex() {
        return sex;
    }
    public void setSex(byte sex) {
        this.sex = sex;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    
}



