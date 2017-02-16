package com.yjs.recyclerview.tantan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yjs.recyclerview.R;

/**
 * Created by yangjingsong on 17/p1/12.
 */

public class TanLayoutManager extends RecyclerView.LayoutManager {

    int defaultMargin;

    public TanLayoutManager(Context context) {
        defaultMargin = (int) context.getResources().getDimension(R.dimen.default_margin);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        if (getItemCount() < 0 || state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        for (int i = getItemCount() - 1; i >= 0; i--) {
            View view = recycler.getViewForPosition(i);

            addView(view);
            measureChildWithMargins(view, 0, 0);

            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            int widthSpace = getWidth() - width;
            int heightSpace = getHeight() - height;
            int left = widthSpace / 2;
            int right = left + width;
            int top = heightSpace / 2;
            int bottom = top + height;
            layoutDecorated(view, left, top, right, bottom);
            //int positionToUser = getItemCount() - 1 - i;

            if(i==0){
                continue;
            }
            if (i > 0 && i < 3) {
                view.setScaleX(1f - i * 0.1f);
                view.setScaleY(1f - i * 0.1f);
                view.setTranslationY(defaultMargin * i * 2);
            }else {
                view.setScaleX(1f - 3 * 0.1f);
                view.setScaleY(1f - 3 * 0.1f);
                view.setTranslationY(defaultMargin * 3 * 2);

            }


        }
    }
}
