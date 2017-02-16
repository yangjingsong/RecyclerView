package com.yjs.recyclerview.baseadapter;


import com.yjs.recyclerview.R;

/**
 * Created by BlingBling on 2016/10/11.
 */

public final class SimpleLoadMoreView extends LoadMoreView {

    @Override public int getLayoutId() {
        return R.layout.loading;
    }

    @Override protected int getLoadingViewId() {
        return 0;
    }

    @Override protected int getLoadFailViewId() {
        return 0;
    }

    @Override protected int getLoadEndViewId() {
        return 0;
    }
}
