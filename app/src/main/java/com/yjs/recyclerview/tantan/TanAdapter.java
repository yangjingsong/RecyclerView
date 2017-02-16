package com.yjs.recyclerview.tantan;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yjs.recyclerview.R;

import java.util.List;

/**
 * Created by yangjingsong on 17/p1/12.
 */

public class TanAdapter extends RecyclerView.Adapter<TanAdapter.TanViewHolder> {
    List<Integer> urls;

    public TanAdapter(List<Integer> urls){
        this.urls = urls;
    }

    @Override
    public TanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tan,parent,false);
        return new TanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TanViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext())
                .load(urls.get(position))
                .into(holder.imageView);
        //holder.imageView.setImageResource(urls.get(position));

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    static class TanViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public TanViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
