package com.nabt.cook.dao.wrapper;

import com.nabt.cook.dao.db.TypeDao;
import com.nabt.cook.dao.entity.Type;

import java.util.List;

/**
 * Created by 14k on 2017/7/25.
 */

public class TypeDaoWrapper {
    private TypeDao typeDao;

    public TypeDaoWrapper(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void save(List<Type> typeList){
        typeDao.insertInTx(typeList);
    }

    public List<Type> list(){
        return typeDao.loadAll();
    }
}
