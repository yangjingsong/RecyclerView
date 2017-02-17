package com.yjs.recyclerview.baseadapter;

import android.view.View;
import android.widget.TextView;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.adapter.*;

/**
 * Created by yangjingsong on 17/2/13.
 */

public class ViewHolderOne extends com.yjs.recyclerview.adapter.BaseViewHolder<ChannelEntity> {
    public ViewHolderOne(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(ChannelEntity model, int position) {
        TextView textView = (TextView) getView(R.id.tv);
        textView.setText(model.getName());
    }
}
