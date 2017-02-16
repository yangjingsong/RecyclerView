package com.yjs.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.R;

import java.util.List;

/**
 * Created by yangjingsong on 17/p1/4.
 */

public class CityAdapter extends RecyclerView.Adapter {

    List<ChannelEntity> cityEntities;

    public CityAdapter(List<ChannelEntity> list){
        cityEntities = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_channel_header,parent,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CityViewHolder){
            ((CityViewHolder) holder).textView.setText(cityEntities.get(position).getName());
        }

    }

    @Override
    public int getItemCount() {
        return cityEntities.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public CityViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.cityTv);
        }
    }

    static class MyCityViewHolder extends BaseViewHolder<ChannelEntity>{

        public MyCityViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setUpView(ChannelEntity model, int position) {
            TextView textView = (TextView) getView(R.id.tv);
            textView.setText(model.getName());

        }
    }
}
