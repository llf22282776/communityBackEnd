package com.lubao.forbackend.domain;

import java.io.Serializable;

public class NidsRequest implements Serializable{
    private int[] cids;//一系列的cid
    private int[] nids;//这个人的nid
    public int[] getCids() {
        return cids;
    }
    public void setCids(int[] cids) {
        this.cids = cids;
    }
    public int[] getNids() {
        return nids;
    }
    public void setNids(int[] nids) {
        this.nids = nids;
    }
    

}
