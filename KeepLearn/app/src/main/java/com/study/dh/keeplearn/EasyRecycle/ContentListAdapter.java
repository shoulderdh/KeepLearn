package com.study.dh.keeplearn.EasyRecycle;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by donghui on 2017/2/3.
 */

public class ContentListAdapter  extends RecyclerArrayAdapter<Content> {

    public ContentListAdapter(Context context) {
        super(context);
    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(parent);
    }
}
