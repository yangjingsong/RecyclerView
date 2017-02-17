package com.yjs.recyclerview.baseadapter;

import android.view.View;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.EntityTwo;

/**
 * Created by yangjingsong on 17/2/13.
 */

public interface TypeFactory {
    BaseViewHolder createViewHolder(int type, View itemView);
    int type(ChannelEntity channelEntity);
    int type(EntityTwo entityTwo);
}
