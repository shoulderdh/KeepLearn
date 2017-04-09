package com.study.dh.theyear.entry;

/**
 * Created by dh on 2017/4/9.
 */

public class Category  extends BaseBean {

    public String  name;

    public Category() {

    }

    public Category(long  id, String name) {
        this.name = name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
