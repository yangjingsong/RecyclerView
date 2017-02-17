package com.yjs.recyclerview.baseadapter;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by yangjingsong on 17/2/17.
 */

public abstract class DiffCallBack<T> extends DiffUtil.Callback {
    List<T> mOldData, mNewData;

    public DiffCallBack(List<T> oldData,List<T> newData){
        mOldData = oldData;
        mNewData = newData;
    }
    @Override
    public int getOldListSize() {
        return mOldData != null ? mOldData.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewData != null ? mNewData.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return areItemsTheSame(oldItemPosition,newItemPosition,mOldData,mNewData);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return areContentsTheSame(oldItemPosition,newItemPosition,mOldData,mNewData);
    }

    public abstract boolean areItemsTheSame(int oldItemPosition, int newItemPosition,List<T> oldData,List<T> newData);

    public abstract boolean areContentsTheSame(int oldItemPosition, int newItemPosition,List<T> oldData,List<T> newData);
}