package com.yjs.recyclerview.baseadapter;

import android.view.View;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.EntityTwo;
import com.yjs.recyclerview.R;


/**
 * Created by yangjingsong on 17/2/13.
 */

public class ItemTypeFactory implements TypeFactory{
    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type){
            case R.layout.item_my:
                return new ViewHolderOne(itemView);
            case R.layout.item_other:
                return new ViewHolderTwo(itemView);
        }
        return null;
    }

    @Override
    public int type(ChannelEntity channelEntity) {
        return R.layout.item_my;
    }

    @Override
    public int type(EntityTwo entityTwo) {
        return R.layout.item_other;
    }
}
