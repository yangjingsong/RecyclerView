package com.yjs.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by yangjingsong on 17/1/3.
 */

public class RecyclerItemTouchHelperCallback extends ItemTouchHelper.Callback {
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if(viewHolder.getItemViewType()!=target.getItemViewType()){
            return false;
        }
        if(recyclerView.getAdapter() instanceof OnItemMovedListener){
            OnItemMovedListener onItemMovedListener = (OnItemMovedListener) recyclerView.getAdapter();
            onItemMovedListener.onItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if(actionState == ItemTouchHelper.ACTION_STATE_IDLE){
            return;
        }
        viewHolder.itemView.setScaleX(1.2f);
        viewHolder.itemView.setScaleY(1.2f);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setScaleX(1f);
        viewHolder.itemView.setScaleY(1f);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }
}
