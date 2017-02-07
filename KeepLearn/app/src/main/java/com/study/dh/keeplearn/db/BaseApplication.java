package com.study.dh.keeplearn.db;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dh on 2017/2/7.
 */

public class BaseApplication  extends Application {
    private  static  DaoSession  daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();

    }

    private void setupDatabase() {
        //create  database - -  shop.db
        DaoMaster.DevOpenHelper  helper=new DaoMaster.DevOpenHelper(this,"shop.db",null);
        SQLiteDatabase  db=helper.getWritableDatabase();    //获取可写数据库
        DaoMaster  daoMaster=new DaoMaster(db);      //获取数据库对象
        daoSession=daoMaster.newSession();    //获取Dao对象管理者
    }

    public  static  DaoSession  getDaoInstant(){
        return  daoSession ;
    }
}
