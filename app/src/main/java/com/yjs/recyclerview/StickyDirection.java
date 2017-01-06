package com.yjs.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by yangjingsong on 17/1/3.
 */

public class StickyDirection extends RecyclerView.ItemDecoration {
    List<ChannelEntity> channelList;
    int height;
    Paint backPaint;
    TextPaint textPaint;

    public StickyDirection(List<ChannelEntity> entities, Context context) {
        channelList = entities;
        height = (int) context.getResources().getDimension(R.dimen.top);
        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(Color.GRAY);

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(60);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        if (isFirstItemInGroup(pos)) {
            outRect.top = height;
        } else {
            outRect.top = 0;
        }

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getLeft();
        int right = parent.getWidth();
        for (int i = 0, n = parent.getChildCount(); i < n; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            String text = channelList.get(position).getLetter();
            if(isFirstItemInGroup(position)){
                int top = view.getTop()- height;
                int bottom = view.getTop();
                c.drawRect(left,top,right,bottom,backPaint);
                c.drawText(text,0,text.length(),left+30,bottom-20,textPaint);
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        final int position = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        if (position == RecyclerView.NO_POSITION) {
            return;
        }
        View child = parent.findViewHolderForAdapterPosition(position).itemView;
        String initial = getTag(position);
        if (initial == null) {
            return;
        }

        //flag指示当标题栏是否发生碰撞（如开头gif图中指示的）
        boolean flag = false;
        if (getTag(position + 1) != null && !initial.equals(getTag(position + 1))) {
            if (child.getHeight() + child.getTop() < height) {
                //与restore()对应，表示下面translate平移坐标系只对绘制当前标题栏生效
                c.save();
                flag = true;
                //translate使发生碰撞时，两个标题栏紧贴，制造出挤开的效果（dy<0,表示绘制偏下）
                c.translate(0, child.getHeight() + child.getTop() - height);
            }
        }

        c.drawRect(parent.getPaddingLeft(), parent.getPaddingTop(),
                parent.getRight() - parent.getPaddingRight(), parent.getPaddingTop() + height, backPaint);
        c.drawText(initial, child.getPaddingLeft() + 30,
                parent.getPaddingTop() + height - (height - textPaint.getTextSize()) / 2 , textPaint);

        if (flag) {
            c.restore();
        }
//        int position = ((LinearLayoutManager)(parent.getLayoutManager())).findFirstVisibleItemPosition();
//        String text = channelList.get(position).getLetter();
//        String nextText = channelList.get(position+1).getLetter();
//        int stickyTop =0;
//        if(!text.equals(nextText)){
//            View nextView = ((LinearLayoutManager)(parent.getLayoutManager())).findViewByPosition(position+1);
//            int nextTop = nextView.getTop();
//            Log.d("nextTop",nextTop+"");
//            stickyTop = height-nextTop;
//        }
//        int left = parent.getLeft();
//        int right = parent.getWidth();
//        c.drawRect(left,0,right,height,backPaint);
//        c.drawText(text,0,text.length(),left+30,height-20,textPaint);
    }

    private boolean isFirstItemInGroup(int position) {
        if (position == 0) {
            return true;
        }
        if (channelList.get(position).getLetter().equals(channelList.get(position - 1).getLetter())) {
            return false;
        } else {
            return true;
        }

    }

    private String getTag(int position){
        return channelList.get(position).getLetter();
    }
}
