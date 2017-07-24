package com.dao.wrapper;

import android.content.Context;

import com.dao.db.DaoMaster;
import com.dao.db.DaoSession;


public class DbMaster {
    private static DbMaster mInstance;
    private DetailDaoWrapper detailDaoWrapper;

    public static DbMaster $(){
        synchronized (DbMaster.class){
            if(null == mInstance){
                synchronized (DbMaster.class){
                    mInstance = new DbMaster();
                }
            }
        }
        return mInstance;
    }

    private DbMaster(){

    }

    public void init(Context ctx){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(ctx,"health.db",null);
        DaoMaster master = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession session = master.newSession();
        detailDaoWrapper = new DetailDaoWrapper(session.getDbDetailDao());
    }

    public DetailDaoWrapper detailDao() {
        return detailDaoWrapper;
    }
}
