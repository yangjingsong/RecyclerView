package com.yjs.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by yangjingsong on 17/1/3.
 */

public class StickyDirection extends RecyclerView.ItemDecoration {
    List<ChannelEntity> channelList;

    public StickyDirection(List<ChannelEntity> entities) {
        channelList = entities;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        if(isFirstItemInGroup(pos)){
            outRect.top = 50;
        }else {
            outRect.top = 0;
        }

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getLeft();
        int right = parent.getWidth();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    private boolean isFirstItemInGroup(int position) {
        if(position == 0){
            return true;
        }
        if (channelList.get(position).getLetter().equals(channelList.get(position - 1).getLetter())) {
            return false;
        } else {
            return true;
        }

    }
}
