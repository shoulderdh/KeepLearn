package com.study.dh.keeplearn.zhihuDaily.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.study.dh.keeplearn.EasyRecycle.ContentViewHolder;
import com.study.dh.keeplearn.network.PicInfo;

/**
 * Created by dh on 2017/2/8.
 */

public class TitleInfoAdapter  extends RecyclerArrayAdapter<PicInfo> {
    public TitleInfoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(parent);
    }
}
