package com.study.dh.lockapp.tools;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by dh on 2017/3/15.
 */

public class MyProvider  extends ContentProvider {

    private  static  final  int BOOK_DIR=0;
    private  static  final  int BOOK_ITEM=1;
    public  static  final  int CATEGORY_DIR=2;
    public  static  final  int CATEGORY_ITEM=3;

    public   static  final  String AUTHORITY="com.study.dh.lockapp.provider";

    private  static UriMatcher  uriMatcher;
    private MyDatabaseHelper  myDatabaseHelper;
    //private DatabaseH

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);

    }

    @Override
    public boolean onCreate() {    //完成数据库的创建和升级
        myDatabaseHelper=new MyDatabaseHelper(getContext(),"BookStore.dh",null,2);
        return true;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {   //增
        SQLiteDatabase  db=myDatabaseHelper.getWritableDatabase();
        Uri uri1=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookid=db.insert("Book",null,contentValues);
                uri1=Uri.parse("content://"+AUTHORITY+"/book/"+newBookid);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long categoryId=db.insert("Book",null,contentValues);
                uri1=Uri.parse("content://"+AUTHORITY+"/category/"+categoryId);
                break;
        }
        return uri1;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {   //删

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {   //改
        return 0;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {  //查
        SQLiteDatabase  db=myDatabaseHelper.getReadableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor=db.query("Book",strings,s,strings1,null,null,s1);
                break;
            case BOOK_ITEM:
                String bookID=uri.getPathSegments().get(1);
                cursor=db.query("Book",strings,"id=?",new String[]{bookID},null,null,s1);
                break;
            case CATEGORY_DIR:
                cursor=db.query("Category",strings,s,strings1,null,null,s1);

                break;
            case CATEGORY_ITEM:
                String categoryID=uri.getPathSegments().get(1);
                cursor=db.query("Book",strings,"id=?",new String[]{categoryID},null,null,s1);
                break;
        }
        return cursor;
    }


    @Nullable
    @Override
    public String getType(Uri uri) {   //根据传入的URI来返回相应的MIME类型
        return null;
    }

}
