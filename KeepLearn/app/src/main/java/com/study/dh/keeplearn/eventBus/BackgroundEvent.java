package com.study.dh.keeplearn.eventBus;

/**
 * Created by dh on 2017/2/14.
 */

public class BackgroundEvent {
    private String  message;

    public BackgroundEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
