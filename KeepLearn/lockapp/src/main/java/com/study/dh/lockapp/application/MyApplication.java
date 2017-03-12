package com.study.dh.lockapp.application;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dh on 2017/3/11.
 */

public class MyApplication  extends Application {
    public static MyApplication instance;
    private static ArrayList<String> lockList;
    private static HashMap<String,Boolean> booleanStates;

    public static MyApplication getInstance() {
        return instance;
    }

    public static ArrayList<String> getLockList() {
        return lockList;
    }

    public static HashMap<String, Boolean> getBooleanStates() {
        return booleanStates;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        this.lockList = new ArrayList<>();
        this.booleanStates = new HashMap<>();
    }


}
