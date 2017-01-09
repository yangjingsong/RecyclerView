package com.yjs.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangjingsong on 17/1/9.
 */

public class MyLayoutManager extends RecyclerView.LayoutManager {

    //所有item的高度之和
    int totalHeight = 0;
    //垂直方向的偏移量
    int verticalScrollOffset = 0;
    //存放每个item的位置
    SparseArray<Rect> allItemFrames = new SparseArray<>();

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams
                (RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);

        if (getItemCount() < 0) {
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        //缓存所有的View到scrap中
        detachAndScrapAttachedViews(recycler);
        int offSetY = 0;
        totalHeight = 0;
        for (int i = 0; i < getItemCount(); i++) {
            //取出缓存的View
            View view = recycler.getViewForPosition(i);
            //把View加到recyclerview中
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            offSetY += height;
            totalHeight += height;
            Rect frame = allItemFrames.get(i);
            if (frame == null) {
                frame = new Rect();
            }
            frame.set(0, offSetY, width, offSetY + height);
            allItemFrames.put(i, frame);
        }
        recycleAndFillItems(recycler, state);
    }

    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        Rect displayFrame = new Rect(0, verticalScrollOffset, getHorizontalSpace(), verticalScrollOffset + getVerticalSpace());

        //将滑出屏幕的View进行回收
        Rect childFrame = new Rect();
        for (int i = 0; i < getItemCount(); i++) {
            View child = getChildAt(i);
            if(child!=null){
                childFrame.left = getDecoratedLeft(child);
                childFrame.top = getDecoratedTop(child);
                childFrame.right = getDecoratedRight(child);
                childFrame.bottom = getDecoratedBottom(child);
                if (!Rect.intersects(displayFrame, childFrame)) {
                    removeAndRecycleView(child, recycler);
                }
            }

        }

        //重新布局在屏幕上的View
        for (int i = 0; i < getItemCount(); i++) {
            if (Rect.intersects(displayFrame, allItemFrames.get(i))) {
                View scrap = recycler.getViewForPosition(i);
                measureChildWithMargins(scrap, 0, 0);
                addView(scrap);
                Rect frame = allItemFrames.get(i);
                layoutDecorated(scrap, frame.left, frame.top - verticalScrollOffset, frame.right, frame.bottom - verticalScrollOffset);
            }
        }
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int realScrollDistance = dy;
        if (verticalScrollOffset + dy < 0) {
            realScrollDistance = -verticalScrollOffset;
        } else if (verticalScrollOffset + dy > totalHeight - getVerticalSpace()) {
            realScrollDistance = totalHeight - getVerticalSpace() - verticalScrollOffset;
        }
        verticalScrollOffset += realScrollDistance;
        offsetChildrenVertical(-realScrollDistance);
        recycleAndFillItems(recycler, state);
        return realScrollDistance;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }

    private int getHorizontalSpace() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }
}
