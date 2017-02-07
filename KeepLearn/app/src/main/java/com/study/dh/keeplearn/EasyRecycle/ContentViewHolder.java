package com.study.dh.keeplearn.EasyRecycle;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.R;
import com.study.dh.keeplearn.network.PicInfo;

/**
 * Created by donghui on 2017/2/3.
 */

  public class ContentViewHolder  extends BaseViewHolder<PicInfo> {
     private TextView  content_name;
     private TextView  content_time;
     private ImageView  content_pic;

    public ContentViewHolder(ViewGroup parent) {
        super(parent, R.layout.content_item);
        content_name=$(R.id.content_name);
        content_time=$(R.id.content_time);
        content_pic=$(R.id.content_pic);
    }

    @Override
    public void setData(PicInfo data) {
        super.setData(data);
     //   content_name.setText(data.getCreTime());
     //   content_time.setText(data.getPicTitle());
        Picasso.with(getContext()).load(data.getPicUrl()).resize(100,100).centerCrop().into(content_pic);
    }
}
