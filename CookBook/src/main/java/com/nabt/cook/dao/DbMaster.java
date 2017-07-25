package com.nabt.cook.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nabt.cook.dao.db.DaoMaster;
import com.nabt.cook.dao.db.DaoSession;
import com.nabt.cook.dao.wrapper.BookDaoWrapper;
import com.nabt.cook.dao.wrapper.TypeDaoWrapper;

/**
 * Created by 14K on 2017/7/25.
 */

public class DbMaster {

    private DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;

    private BookDaoWrapper bookDaoWrapper;
    private TypeDaoWrapper typeDaoWrapper;

    private static DbMaster _$;

    private DbMaster(){

    }

    public static DbMaster $(){
        if(_$ == null){
            synchronized (DbMaster.class){
                _$ = new DbMaster();
            }
        }
        return _$;
    }

    public void init(Context ctx){
        helper = new DaoMaster.DevOpenHelper(ctx, ctx.getPackageName(), null);
        db = helper.getWritableDatabase();
        daoMaster =new DaoMaster(db);
        daoSession = daoMaster.newSession();

        bookDaoWrapper = new BookDaoWrapper(daoSession.getBookDao());
        typeDaoWrapper = new TypeDaoWrapper(daoSession.getTypeDao());
    }

    public BookDaoWrapper book() {
        return bookDaoWrapper;
    }

    public TypeDaoWrapper type() {
        return typeDaoWrapper;
    }
}
