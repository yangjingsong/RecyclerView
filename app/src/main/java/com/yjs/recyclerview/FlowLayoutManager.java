package com.yjs.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangjingsong on 17/2/14.
 */

public class FlowLayoutManager extends RecyclerView.LayoutManager {

    int verticalOffset = 0;//垂直方向的偏移量
    int firstVisiblePos = 0;
    int lastVisiblePos = 0;


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        verticalOffset = 0;
        fillView(recycler, state, 0);
    }

    private void fillView(RecyclerView.Recycler recycler, RecyclerView.State state, int dy) {
        int topOffset = getPaddingTop();
        int leftOffset = getPaddingLeft();
        int lineMaxHeight = 0;
        int minPos = firstVisiblePos;
        lastVisiblePos = getItemCount() - 1;
        for (int i = minPos; i < lastVisiblePos; i++) {
            View child = recycler.getViewForPosition(i);
            addView(child);
            measureChild(child, 0, 0);
            if (leftOffset + getDecoratedMeasuredWidth(child) <= getHorizontalSpace()) {
                layoutDecoratedWithMargins(child, leftOffset,
                        topOffset, leftOffset + getDecoratedMeasuredWidth(child),
                        topOffset + getDecoratedMeasuredHeight(child));
                leftOffset += getDecorateMeasurementHorizontal(child);
                lineMaxHeight = Math.max(lineMaxHeight, getDecorateMeasurementVertical(child));
            } else {
                leftOffset = getPaddingLeft();
                topOffset += lineMaxHeight;
                lineMaxHeight = 0;

                if (topOffset - dy > getHeight() - getPaddingBottom()) {
                    removeAndRecycleView(child, recycler);
                    lastVisiblePos = i - 1;
                } else {
                    layoutDecoratedWithMargins(child, leftOffset,
                            topOffset, leftOffset + getDecorateMeasurementHorizontal(child),
                            topOffset + getDecorateMeasurementVertical(child));
                    leftOffset += getDecorateMeasurementHorizontal(child);
                    lineMaxHeight = Math.max(lineMaxHeight, getDecorateMeasurementVertical(child));
                }

            }
        }


    }

    private int getDecorateMeasurementHorizontal(View view) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        return params.leftMargin + params.rightMargin + getDecoratedMeasuredWidth(view);
    }

    private int getDecorateMeasurementVertical(View view) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        return params.topMargin + params.bottomMargin + getDecoratedMeasuredHeight(view);
    }

    private int getHorizontalSpace() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }
}
