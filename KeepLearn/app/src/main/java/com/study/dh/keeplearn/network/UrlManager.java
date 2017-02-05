package com.study.dh.keeplearn.network;

/**
 * Created by donghui on 2016/11/1.
 */

public class UrlManager {

    //来自干货集中营，图片API解释：  20 表示返回20条数据， 1，表示翻页
    public  static  final  String  beautyurl="http://gank.io/api/data/福利/20/1";


    public  static  final String baseurl="http://news-at.zhihu.com/api";


    //获取主题列表
    public static String getThemeUrl(){
        return baseurl+"/4/themes";
    }

    //获取启动页图片
    public static String getSplashUrl(){
        return baseurl+"/4/start-image/1080*1776";
    }


    /*软件版本查询   2.3.0代表所安装的版本
     */
    public static String getVersion(){
        return baseurl+"/4/version/android/2.3.0";
    }

    /*最新消息
      {
    date: "20140523",
    stories: [
        {
            title: "中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）",
            ga_prefix: "052321",
            images: [
                "http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"
            ],
            type: 0,
            id: 3930445
        },
    ...
    ],
    top_stories: [
        {
            title: "商场和很多人家里，竹制家具越来越多（多图）",
            image: "http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg",
            ga_prefix: "052315",
            type: 0,
            id: 3930883
        },
    ...
    ]
}
分析：

date : 日期
stories : 当日新闻
title : 新闻标题
images : 图像地址（官方 API 使用数组形式。目前暂未有使用多张图片的情形出现，曾见无 images 属性的情况，请在使用中注意 ）
ga_prefix : 供 Google Analytics 使用
type : 作用未知
id : url 与 share_url 中最后的数字（应为内容的 id）
multipic : 消息是否包含多张图片（仅出现在包含多图的新闻中）
top_stories : 界面顶部 ViewPager 滚动显示的显示内容（子项格式同上）（请注意区分此处的 image 属性与 stories 中的 images 属性）
     */
    public static String getLatestNews(){
        return baseurl+"/4/news/latest";
    }


    /*
    消息内容获取与离线下载  + 最新消息中的 id

     */
    public static String getDetailInfo(){
        return baseurl+"/4/news/";
    }

    /*
    过往消息   +20161222

     */
    public static String getBeforeInfo(){
        return baseurl+"/4/news/before";
    }

     /*
     额外消息     http://news-at.zhihu.com/api/4/story-extra/#{id}
{
    "long_comments": 0,
    "popularity": 161,
    "short_comments": 19,
    "comments": 19,
}
分析：

long_comments : 长评论总数
popularity : 点赞总数
short_comments : 短评论总数
comments : 评论总数
     */
     public static String getExtraInfo(){
         return baseurl+"/4/story-extra/";
     }

}
