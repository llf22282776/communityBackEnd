package com.lubao.forbackend.domain;

import java.io.Serializable;

public class SupportRequest implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int cid ;//帖子id
    private int nid;//人id
    private int type;//支持或者删除
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
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
   
    
    
    
    

}
