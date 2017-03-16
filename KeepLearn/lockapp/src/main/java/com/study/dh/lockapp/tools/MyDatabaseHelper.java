package com.study.dh.lockapp.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by dh on 2017/3/15.
 */

public class MyDatabaseHelper  extends SQLiteOpenHelper {

    public static final  String  CREATE_BOOK="create table Book ("
            +"id integer primary key autoincrement, "
            +"author text, "
            +"price real, "
            +"pages integer, "
            +"name text)";


    public static final  String  CREATE_CATEGORY="create table Category ("
            +"id integer primary key autoincrement, "
            +"author text, "
            +"price real, "
            +"pages integer, "
            +"name text)";

    private Context  mcontext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
         mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
              sqLiteDatabase.execSQL(CREATE_BOOK);
        Toast.makeText(mcontext,"create database success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
              sqLiteDatabase.execSQL("drop table if exists Book");
              sqLiteDatabase.execSQL("drop table if exists Category");
              onCreate(sqLiteDatabase);

    }

}
