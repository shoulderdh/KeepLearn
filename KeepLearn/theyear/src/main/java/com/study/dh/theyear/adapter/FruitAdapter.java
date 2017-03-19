package com.study.dh.theyear.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.study.dh.theyear.R;
import com.study.dh.theyear.entry.Fruit;

import java.util.List;

/**
 * Created by dh on 2017/3/16.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruitList;
    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_horizontal_item,parent,false);
        final ViewHolder  holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=fruitList.get(position);
                Toast.makeText(view.getContext(),"click item"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=fruitList.get(position);
                Toast.makeText(view.getContext(),"click  img"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
             Fruit  fruit=fruitList.get(position);
             holder.fruitTxt.setText(fruit.getName());
             holder.fruitImag.setImageResource(fruit.getImgId());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View  fruitView;
        ImageView  fruitImag;
        TextView   fruitTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView=itemView;
            fruitImag= (ImageView) itemView.findViewById(R.id.fruitImg);
            fruitTxt= (TextView) itemView.findViewById(R.id.fruitTxt);
        }
    }
}
