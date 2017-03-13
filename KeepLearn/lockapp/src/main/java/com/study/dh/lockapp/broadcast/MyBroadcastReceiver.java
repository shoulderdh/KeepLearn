package com.study.dh.lockapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by dh on 2017/3/13.
 */

public class MyBroadcastReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
