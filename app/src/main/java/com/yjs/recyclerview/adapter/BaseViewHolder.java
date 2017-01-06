package com.yjs.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;


/**
 * Created by yangjingsong on 17/1/6.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private View convertView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        convertView = itemView;
        views = new SparseArray<>();
    }

    public View getView(int resId){
        View view = views.get(resId);
        if(view == null){
            view = convertView.findViewById(resId);
            views.put(resId,view);
        }
        return view;
    }

    public abstract void setUpView(T model,int position);
}
