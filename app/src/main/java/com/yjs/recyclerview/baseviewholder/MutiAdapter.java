package com.yjs.recyclerview.baseviewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yjs.recyclerview.adapter.*;
import com.yjs.recyclerview.adapter.BaseViewHolder;
import com.yjs.recyclerview.baseadapter.ItemTypeFactory;
import com.yjs.recyclerview.baseadapter.Visitable;

import java.util.List;

/**
 * Created by yangjingsong on 17/2/13.
 */

public class MutiAdapter extends RecyclerView.Adapter<com.yjs.recyclerview.adapter.BaseViewHolder> {
    ItemTypeFactory itemTypeFactory;
    List<Visitable> data;

    public MutiAdapter(){
        itemTypeFactory = new ItemTypeFactory();
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return itemTypeFactory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setUpView(data.get(position),position);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type(itemTypeFactory);
    }
}
