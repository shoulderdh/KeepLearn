package com.study.dh.lockapp.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh on 2017/3/12.
 */

public class LockUtils {

    public List<String> getHomes(Context  context) {
        List<String> names = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo ri : resolveInfo) {
            names.add(ri.activityInfo.packageName);
        }
        return names;
    }

//    /**
//     * Home键操作
//     */
//    public static void goHome(BaseActivity activity) {
//        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
//        homeIntent.addCategory(Intent.CATEGORY_HOME);
//        activity.startActivity(homeIntent);
//        activity.finish();
//    }
}
