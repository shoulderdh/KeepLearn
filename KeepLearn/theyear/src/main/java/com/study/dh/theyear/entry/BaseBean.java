package com.study.dh.theyear.entry;

import java.io.Serializable;

/**
 * Created by dh on 2017/4/9.
 */

public class BaseBean  implements Serializable {
    protected   long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
