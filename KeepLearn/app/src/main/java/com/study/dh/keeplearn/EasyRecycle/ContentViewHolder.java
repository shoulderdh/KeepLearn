package com.study.dh.keeplearn.EasyRecycle;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.study.dh.keeplearn.R;

/**
 * Created by donghui on 2017/2/3.
 */

  public class ContentViewHolder  extends BaseViewHolder<Content> {
     private TextView  content_name;
     private TextView  content_time;


    public ContentViewHolder(ViewGroup parent) {
        super(parent, R.layout.content_item);
        content_name=$(R.id.content_name);
        content_time=$(R.id.content_time);

    }

    @Override
    public void setData(Content data) {
        super.setData(data);
        content_name.setText(data.getName());
        content_time.setText(data.getTime());
    }
}
