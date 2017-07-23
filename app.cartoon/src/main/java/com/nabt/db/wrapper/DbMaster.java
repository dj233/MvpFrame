package com.nabt.db.wrapper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nabt.db.dao.DaoMaster;
import com.nabt.db.dao.DaoSession;

public class DbMaster {

    private DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;

    private BookWrapper bookWrapper;

    private static DbMaster _ins;

    public static DbMaster $(){
        if(_ins == null){
            synchronized (DbMaster.class){
                _ins = new DbMaster();
            }
        }
        return _ins;
    }

    private DbMaster(){}

    public void init(Context context){
        //创建数据库
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(context, context.getPackageName(), null);
        //得到数据库连接对象
        db = helper.getWritableDatabase();
        //得到数据库管理者
        daoMaster =new DaoMaster(db);
        //得到daoSession，可以执行增删改查操作
        daoSession = daoMaster.newSession();

        bookWrapper = new BookWrapper(daoSession.getDBookDao());
    }

    public BookWrapper $Book(){
        return bookWrapper;
    }
}
