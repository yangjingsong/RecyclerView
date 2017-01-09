package com.yjs.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yjs.recyclerview.R;

/**
 * Created by yangjingsong on 17/1/9.
 */

public class LayoutManagerAdapter extends RecyclerView.Adapter<LayoutManagerAdapter.MyViewHolder> {

    SparseArray<String> array;

    public LayoutManagerAdapter(SparseArray<String> array){
        this.array = array;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setUpView(array.get(position),position);
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    static class MyViewHolder extends BaseViewHolder<String>{

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setUpView(String model, int position) {
            TextView textView = (TextView) getView(R.id.tv);
            textView.setText(model);
        }
    }
}
