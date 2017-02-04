package com.study.dh.keeplearn.Util;

/**
 * Created by donghui on 2017/2/3.
 */

 /*
 *
 * 暂时只提供计算两个时间的差值
 */
public class TimeUtils {
    /*
    *计算time2减去time1的差值 差值只设置 几天 几个小时 或 几分钟
    * 根据差值返回多长之间前或多长时间后
    * */
    public static String getDistanceTime(long  time1,long time2 ) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff ;
        String flag;
        if(time1<time2) {
            diff = time2 - time1;
            flag="前";
        } else {
            diff = time1 - time2;
            flag="后";
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        if(day!=0)return day+"天"+flag;
        if(hour!=0)return hour+"小时"+flag;
        if(min!=0)return min+"分钟"+flag;
        return "刚刚";
    }
}

//／／how  to  use
//
//        Long createTime = helpBean.getParameters().getHelp().getCreateTime();
///*System.currentTimeMillis()：
//Returns the current time in milliseconds since January 1, 1970 00:00:00.0 UTC.*/
//        String timeDistance = TimeUtils.getDistanceTime(createTime, System.currentTimeMillis());
//        tvPublishTime.setText(timeDistance);
