package com.yjs.recyclerview.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by yangjingsong on 17/2/13.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{

    View mItemView;
    SparseArray<View> mViews;
    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    public View getView(int resId){
        View view = mViews.get(resId);
        if(view == null){
            view = mItemView.findViewById(resId);
            mViews.put(resId,view);
        }
        return view;
    }

    public void setVisibility(int resId,boolean visible){
        View view = getView(resId);
        if(view!=null){
            view.setVisibility(visible?View.VISIBLE:View.GONE);
        }
    }

    public abstract void bindData(T data);
}
