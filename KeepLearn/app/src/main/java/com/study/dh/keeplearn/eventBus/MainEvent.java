package com.study.dh.keeplearn.eventBus;

/**
 * Created by dh on 2017/2/14.
 */

public class MainEvent {
    private String  message;

    public MainEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
