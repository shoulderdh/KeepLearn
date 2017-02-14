package com.study.dh.keeplearn.eventBus;

/**
 * Created by dh on 2017/2/14.
 */

public class AsyncEvent {
    private String  message;

    public AsyncEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
