package com.study.dh.lockapp.myinterface;

/**
 * Created by dh on 2017/3/14.
 */

public interface DonwloadListener {

    void  onProgress(int progress);
    void  onSuccess();
    void  onFailure();
    void  onPaused();
    void  onCanceled();

}
