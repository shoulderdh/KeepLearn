package com.study.dh.lockapp.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by dh on 2017/3/11.
 */

public class LockReceiver extends BroadcastReceiver {
    private   static Context  mainContext;
    private ArrayList<String>  lockListName;

    @Override
    public void onReceive(Context context, Intent intent) {
           if (mainContext==null){
               mainContext=context;
           }
        lockListName=intent.getStringArrayListExtra("lockListName");

    }
}
