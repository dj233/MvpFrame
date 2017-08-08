package com.nabt.cook.dao.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.nabt.cook.dao.entity.Type;
import com.nabt.cook.dao.entity.Book;
import com.nabt.cook.dao.entity.Step;

import com.nabt.cook.dao.db.TypeDao;
import com.nabt.cook.dao.db.BookDao;
import com.nabt.cook.dao.db.StepDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig typeDaoConfig;
    private final DaoConfig bookDaoConfig;
    private final DaoConfig stepDaoConfig;

    private final TypeDao typeDao;
    private final BookDao bookDao;
    private final StepDao stepDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        typeDaoConfig = daoConfigMap.get(TypeDao.class).clone();
        typeDaoConfig.initIdentityScope(type);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        stepDaoConfig = daoConfigMap.get(StepDao.class).clone();
        stepDaoConfig.initIdentityScope(type);

        typeDao = new TypeDao(typeDaoConfig, this);
        bookDao = new BookDao(bookDaoConfig, this);
        stepDao = new StepDao(stepDaoConfig, this);

        registerDao(Type.class, typeDao);
        registerDao(Book.class, bookDao);
        registerDao(Step.class, stepDao);
    }
    
    public void clear() {
        typeDaoConfig.getIdentityScope().clear();
        bookDaoConfig.getIdentityScope().clear();
        stepDaoConfig.getIdentityScope().clear();
    }

    public TypeDao getTypeDao() {
        return typeDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public StepDao getStepDao() {
        return stepDao;
    }

}