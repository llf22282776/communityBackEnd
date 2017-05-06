package com.lubao.forbackend.service;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.CoversionMix;
import com.lubao.forbackend.domain.CoversionTable;
import com.lubao.forbackend.domain.NidAndCid;
@Service
public interface CoversionService {
    public CoversionTable getCoversionTablesById(int nid);//获得指定对话
    public CoversionMix getCoversionMix(int cid);//获得
    public int insertCoversion(CoversionTable coversionTable);//插入话题
    public CoversionMix[] getCoversions();//获取帖子
    public CoversionMix[] searchCoversions(String keyword);//搜索
    public int upDateCoversion(int cid);//帖子数加1
    public int supportCoversionOrNot(int cid,int nid,int type);//点赞或取消点赞
    public boolean isSupport(NidAndCid nidAndCid);//检查用户是否已经点赞
}
