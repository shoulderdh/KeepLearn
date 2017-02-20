package com.study.dh.keeplearn.db;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArraySet;
import android.util.Log;

import com.facebook.stetho.Stetho;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by dh on 2017/2/7.
 */

public class BaseApplication  extends Application {
    private  static  DaoSession  daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        Set<String>  strings=new HashSet<>();
         strings.add("tech");
        strings.add("read");

        JPushInterface.setTags(this, strings, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Log.i("tag","the result is "+i);     //推送不同标签，  用户订阅不同内容，收获不同推送；  体育，游戏，科技  之类的
            }
        });

        setupDatabase();
        setupNewsDb();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    private void setupNewsDb() {
        DaoMaster.DevOpenHelper  helper=new DaoMaster.DevOpenHelper(this,"news.db",null);
        SQLiteDatabase  db=helper.getWritableDatabase();    //获取可写数据库
        DaoMaster  daoMaster=new DaoMaster(db);      //获取数据库对象
        daoSession=daoMaster.newSession();    //获取Dao对象管理者
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
