package com.lubao.forbackend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lubao.forbackend.dao.CoversionDAO;
import com.lubao.forbackend.domain.CoversionMix;
import com.lubao.forbackend.domain.CoversionTable;
import com.lubao.forbackend.domain.NidAndCid;
import com.lubao.forbackend.util.Constant;

@Service
public class CoversionServiceImp implements CoversionService {
    @Resource
    private CoversionDAO coversionDAO;

    @Override
    public CoversionTable getCoversionTablesById(int nid) {
        // TODO Auto-generated method stub
        return coversionDAO.getCoversionTablesById(nid);
    }

    @Override
    public int insertCoversion(CoversionTable coversionTable) {
        // TODO Auto-generated method stub
        return coversionDAO.insertCoversion(coversionTable);
    }

    @Override
    public CoversionMix getCoversionMix(int cid) {
        // TODO Auto-generated method stub
        return coversionDAO.getCoversionMix(cid);
    }

    @Override
    public CoversionMix[] getCoversions() {
        // TODO Auto-generated method stub
        return coversionDAO.getCoversions();
    }

    @Override
    public CoversionMix[] searchCoversions(String keyword) {
        // TODO Auto-generated method stub
        return coversionDAO.searchCoversions(keyword);
    }

    @Override
    public int upDateCoversion(int cid) {
        // TODO Auto-generated method stub
        return coversionDAO.upDateCoversion(cid);
    }

    @Override
    public int supportCoversionOrNot(int cid, int nid, int type) {
        // TODO Auto-generated method stub
        if (type == Constant.SUPPORT) {
            // 去支持，那就
            NidAndCid nCid = new NidAndCid();
            nCid.setCid(cid);
            nCid.setNid(nid);
            if (coversionDAO.selectFromSupport(nCid) >= 1) {

                return Constant.SUPPORT;

            } else {
                coversionDAO.supportCoversion(cid);
                coversionDAO.insertToSupport(nCid);// 插入一条记录
                return Constant.SUPPORT;
            }
        } else {
            // 去取消
            NidAndCid nCid = new NidAndCid();
            nCid.setCid(cid);
            nCid.setNid(nid);
            if (coversionDAO.selectFromSupport(nCid) < 1) {

                return Constant.UNSUPPORT;

            } else {
                coversionDAO.notSupportCoversion(cid);// 数字减小
                coversionDAO.deleteFromSupport(nCid);// 删除一条记录
                return Constant.UNSUPPORT;
            }

        }

    }

    @Override
    public boolean isSupport(NidAndCid nidAndCid) {
        // TODO Auto-generated method stub

        if (coversionDAO.selectFromSupport(nidAndCid) >= 1) {
            return true;

        }

        return false;
    }

}
