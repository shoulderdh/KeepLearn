package com.study.dh.keeplearn.network;

/**
 * Created by donghui on 2016/11/1.
 */

public class UrlManager {

    //来自干货集中营图片API解释：  20 表示返回20条数据， 1，表示翻页
    public  static  final  String  beautyurl="http://gank.io/";


    public  static  final String zhihuDailybaseurl="http://news-at.zhihu.com/api/";

    public  static  final String localhostdownloadFile="http://192.168.1.101:8080/mytxt/";


    //获取主题列表
    public static String getThemeUrl(){
        return zhihuDailybaseurl+"/4/themes";
    }

    //获取启动页图片
    public static String getSplashUrl(){
        return zhihuDailybaseurl+"/4/start-image/1080*1776";
    }


    /*软件版本查询   2.3.0代表所安装的版本
     */
    public static String getVersion(){
        return zhihuDailybaseurl+"/4/version/android/2.3.0";
    }



    public static String getLatestNews(){
        return zhihuDailybaseurl+"/4/news/latest";
    }


    /*
    消息内容获取与离线下载  + 最新消息中的 id

     */
    public static String getDetailInfo(){
        return zhihuDailybaseurl+"/4/news/";
    }

    /*
    过往消息   +20161222

     */
    public static String getBeforeInfo(){
        return zhihuDailybaseurl+"/4/news/before";
    }


     public static String getExtraInfo(){
         return zhihuDailybaseurl+"/4/story-extra/";
     }

}
