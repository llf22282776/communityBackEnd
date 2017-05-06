package com.lubao.forbackend.dao;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.domain.CoversionMix;
import com.lubao.forbackend.domain.CoversionTable;
import com.lubao.forbackend.domain.NidAndCid;
@Service
public interface CoversionDAO {
    public CoversionTable getCoversionTablesById(int nid);//获得指定对话，某人的

    public int insertCoversion(CoversionTable coversionTable);//插入话题

    public int supportCoversion(int cid);//点赞
    public int notSupportCoversion(int cid);//取消点赞
    
    
    public CoversionMix getCoversionMix(int cid);//获得帖子详情
    public CoversionMix[] getCoversions();//获得多个帖子
    public CoversionMix[] searchCoversions(String keyword);//根据名字搜索帖子
    public int upDateCoversion(int cid);//评论数+1
    public int selectFromSupport(NidAndCid nidAndCid);//看条数是否点赞，点完赞，对话表数量加1
    public int deleteFromSupport(NidAndCid nidAndCid);//删除点赞可能需要，删除完，对话表数量减一
    public int insertToSupport(NidAndCid nidAndCid);//添加一条记录
}
