package com.yjs.recyclerview.tantan;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.yjs.recyclerview.R;

import java.util.List;


/**
 * Created by yangjingsong on 17/1/12.
 */

public class TanItemTouchHelperCallback extends ItemTouchHelper.Callback {
    int defaultMargin;
    List data;
    RecyclerView.Adapter adapter;

    public TanItemTouchHelperCallback(Context context, List data,RecyclerView.Adapter adapter) {
        defaultMargin = (int) context.getResources().getDimension(R.dimen.default_margin);
        this.data = data;
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        int swipeFlag = dragFlag;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int position = viewHolder.getAdapterPosition();
        View view = recyclerView.getChildAt(position);

        Log.d("left", view.getX() + "");

        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Object remove = data.remove(viewHolder.getAdapterPosition());
       // data.add(remove);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        double swipeDistance = Math.sqrt(dX * dX + dY * dY);
        double fraction = swipeDistance / recyclerView.getWidth();
        if (fraction > 1) {
            fraction = 1;
        }
        int count = recyclerView.getChildCount();
//        for (int i = count - 2; i > count - 5; i--) {
//            View view = recyclerView.getChildAt(i);
//            view.setScaleX((float) (1f - i * 0.1f + fraction * 0.05f));
//            view.setScaleY((float) (1f - i * 0.1f + fraction * 0.05f));
//            view.setTranslationY((float) (defaultMargin * i * 2 - defaultMargin * fraction));
//
//        }
    }
}
