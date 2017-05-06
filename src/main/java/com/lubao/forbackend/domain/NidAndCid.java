package com.lubao.forbackend.domain;

import java.io.Serializable;

public class NidAndCid implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int cid;
    private int nid;
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
    

}
