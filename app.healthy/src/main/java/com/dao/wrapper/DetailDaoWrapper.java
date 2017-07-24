package com.dao.wrapper;

import com.dao.db.DbDetailDao;
import com.dao.entity.DbDetail;
import com.market.healthy.entity.Detail;

import java.util.ArrayList;
import java.util.List;


public class DetailDaoWrapper {

    DbDetailDao dao;

    public DetailDaoWrapper(DbDetailDao dao) {
        this.dao = dao;
    }

    public boolean add(Detail detail){
        List<DbDetail> dbDetailList = dao.queryBuilder().where(DbDetailDao.Properties.Id.eq(detail.getId())).list();
        if(dbDetailList == null || dbDetailList.isEmpty()){
            DbDetail dbDetail = toDb(detail);
            dao.insert(dbDetail);
            return true;
        }else{
            return false;
        }
    }

    public List<Detail> list(){
        List<DbDetail> dbDetailList = dao.loadAll();
        List<Detail> detailList = new ArrayList<>();
        if(dbDetailList != null && !dbDetailList.isEmpty()){
            for(DbDetail dbDetail : dbDetailList){
                detailList.add(toNet(dbDetail));
            }
        }
        return detailList;
    }

    private DbDetail toDb(Detail detail){
        DbDetail dbDetail = new DbDetail();
        dbDetail.setTitle(detail.getTitle());
        dbDetail.setImg(detail.getImg());
        dbDetail.setCount(detail.getCount());
        dbDetail.setDescription(detail.getDescription());
        dbDetail.setFcount(detail.getFcount());
        dbDetail.setId(detail.getId());
        dbDetail.setKeywords(detail.getKeywords());
        dbDetail.setLoreclass(detail.getLoreclass());
        dbDetail.setMessage(detail.getMessage());
        dbDetail.setTime(detail.getTime());
        dbDetail.setRcount(detail.getRcount());
        return dbDetail;
    }

    private Detail toNet(DbDetail dbDetail){
        Detail detail = new Detail();
        detail.setTitle(dbDetail.getTitle());
        detail.setImg(dbDetail.getImg());
        detail.setCount(dbDetail.getCount());
        detail.setDescription(dbDetail.getDescription());
        detail.setFcount(dbDetail.getFcount());
        detail.setId(dbDetail.getId());
        detail.setTime(dbDetail.getTime());
        detail.setKeywords(dbDetail.getKeywords());
        detail.setLoreclass(dbDetail.getLoreclass());
        detail.setMessage(dbDetail.getMessage());
        detail.setRcount(dbDetail.getRcount());
        return detail;
    }

}
