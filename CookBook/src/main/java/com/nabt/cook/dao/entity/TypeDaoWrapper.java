package com.nabt.cook.dao.entity;

import com.nabt.cook.dao.db.TypeDao;

import java.util.List;

/**
 * Created by 14k on 2017/7/25.
 */

public class TypeDaoWrapper {
    private TypeDao typeDao;

    public TypeDaoWrapper(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void addAll(List<Type> typeList){
        typeDao.insertInTx(typeList);
    }

    public List<Type> loadAll(){
        return typeDao.loadAll();
    }
}
