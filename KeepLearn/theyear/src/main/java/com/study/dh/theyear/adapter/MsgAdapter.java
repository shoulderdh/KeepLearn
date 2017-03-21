package com.study.dh.theyear.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.dh.theyear.R;
import com.study.dh.theyear.entry.Msg;

import java.util.List;

/**
 * Created by dh on 2017/3/20.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg>  list;


    public MsgAdapter(List<Msg> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Msg  msg=list.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
             holder.right_layout.setVisibility(View.GONE);
             holder.left_layout.setVisibility(View.VISIBLE);
             holder.leftMsg_tv.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SEND){
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.rightMsg_tv.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static  class ViewHolder  extends RecyclerView.ViewHolder{
        LinearLayout  right_layout;
        LinearLayout  left_layout;
        TextView    rightMsg_tv;
        TextView    leftMsg_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            right_layout= (LinearLayout) itemView.findViewById(R.id.right_layout);
            left_layout= (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightMsg_tv= (TextView) itemView.findViewById(R.id.rightMsg_tv);
            leftMsg_tv= (TextView) itemView.findViewById(R.id.leftMsg_tv);
        }
    }

}
