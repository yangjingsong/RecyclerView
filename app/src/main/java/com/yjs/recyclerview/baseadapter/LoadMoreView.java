package com.yjs.recyclerview.baseadapter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.yjs.recyclerview.adapter.*;
import com.yjs.recyclerview.adapter.BaseViewHolder;

/**
 * Created by yangjingsong on 17/2/16.
 */

public abstract class LoadMoreView {
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_END = 4;

    private int mLoadMoreStatus = STATUS_LOADING;
    private boolean mLoadMoreEndGone = false;

    public void setLoadMoreStatus(int loadMoreStatus) {
        this.mLoadMoreStatus = loadMoreStatus;
    }

    public int getLoadMoreStatus() {
        return mLoadMoreStatus;
    }

    public void changeStatus(com.yjs.recyclerview.adapter.BaseViewHolder holder){
        switch (mLoadMoreStatus) {
            case STATUS_LOADING:
                visibleLoading(holder, true);
                visibleLoadFail(holder, false);
                visibleLoadEnd(holder, false);
                break;
            case STATUS_FAIL:
                visibleLoading(holder, false);
                visibleLoadFail(holder, true);
                visibleLoadEnd(holder, false);
                break;
            case STATUS_END:
                visibleLoading(holder, false);
                visibleLoadFail(holder, false);
                visibleLoadEnd(holder, true);
                break;
            case STATUS_DEFAULT:
                visibleLoading(holder, false);
                visibleLoadFail(holder, false);
                visibleLoadEnd(holder, false);
                break;
        }


    }

    private void visibleLoading(BaseViewHolder holder,boolean visible){
        holder.setVisible(getLoadingViewId(),visible);
    }
    private void visibleLoadFail(BaseViewHolder holder, boolean visible) {
        holder.setVisible(getLoadFailViewId(), visible);
    }

    private void visibleLoadEnd(BaseViewHolder holder, boolean visible) {
        final int loadEndViewId=getLoadEndViewId();
        if (loadEndViewId != 0) {
            holder.setVisible(loadEndViewId, visible);
        }
    }



    /**
     * loading view
     *
     * @return
     */
    protected abstract @IdRes int getLoadingViewId();

    /**
     * load fail view
     *
     * @return
     */
    protected abstract @IdRes int getLoadFailViewId();

    /**
     * load end view, you can return 0
     *
     * @return
     */
    protected abstract @IdRes int getLoadEndViewId();
    /**
     * load more layout
     *
     * @return
     */
    public abstract @LayoutRes
    int getLayoutId();


}
