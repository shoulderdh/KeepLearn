package com.study.dh.theyear.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.dh.theyear.R;
import com.study.dh.theyear.entry.HomeCategory;

import java.util.ArrayList;
import java.util.List;

import static com.study.dh.theyear.R.id.fruitTxt;

/**
 * Created by dh on 2017/4/9.
 */

public class GoodsNameAdapter extends RecyclerView.Adapter<GoodsNameAdapter.ViewHolder> {

    private List<HomeCategory>  goodsNames=new ArrayList<>();
    private OnItemClickListener  myOnItemClickListener;

    private static   int VIEW_TYPE_L=1;
    private static   int VIEW_TYPE_R=2;



    public void setMyOnItemClickListener(OnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    public GoodsNameAdapter(List<HomeCategory> goodsNames) {
        this.goodsNames = goodsNames;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==VIEW_TYPE_L){
            View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cardview_left,parent,false);
            return new ViewHolder(view);
        }else {
            View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cardview_right,parent,false);
            return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HomeCategory  category=goodsNames.get(position);
         holder.text_title.setText(category.getName());
         holder.image_small_top.setImageResource(category.getImgSmallTop());
         holder.image_small_bottom.setImageResource(category.getImgSmallBottom());
         holder.image_big.setImageResource(category.getImgBig());

    }

    @Override
    public int getItemCount() {
        return goodsNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView  text_title;
        private ImageView  image_small_top;
        private ImageView  image_small_bottom;
        private ImageView  image_big;



        public ViewHolder(View itemView) {
            super(itemView);
            text_title= (TextView) itemView.findViewById(R.id.text_title);
            image_small_bottom= (ImageView) itemView.findViewById(R.id.image_small_bottom);
            image_small_top= (ImageView) itemView.findViewById(R.id.image_small_top);
            image_big= (ImageView) itemView.findViewById(R.id.image_big);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       if (myOnItemClickListener!=null){
                           myOnItemClickListener.onClick(view,getLayoutPosition(),goodsNames.get(getLayoutPosition()).getName());
                       }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return  VIEW_TYPE_L;
        }else {
            return  VIEW_TYPE_R;
        }
    }

    public void addData(int position, HomeCategory name){
        goodsNames.add(position,name);
        notifyItemInserted(position);

    }

    public void removeData(int position){
        goodsNames.remove(position);
        notifyItemRemoved(position);
    }


  public   interface   OnItemClickListener{
           void  onClick(View v,int position,String city);
    }

}
