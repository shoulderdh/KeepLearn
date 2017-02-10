package com.study.dh.keeplearn.db;

import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by dh on 2017/2/10.
 */

public class ZhihuNews {

    //新闻ID
    @Unique
    private String id;
    //新闻标题
    @Property(nameInDb = "title")
    private String title;
    //新闻图片路径
    private String  url;

    public ZhihuNews(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public ZhihuNews() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
