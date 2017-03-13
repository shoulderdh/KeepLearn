package com.study.dh.lockapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by dh on 2017/3/13.
 */

public class NetworkChangeReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager  connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo  networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isAvailable()){
            Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"network is not available",Toast.LENGTH_SHORT).show();
        }
    }
}
