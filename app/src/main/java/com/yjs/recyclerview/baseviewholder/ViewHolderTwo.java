package com.yjs.recyclerview.baseviewholder;

import android.view.View;
import android.widget.TextView;

import com.yjs.recyclerview.EntityTwo;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.adapter.*;

/**
 * Created by yangjingsong on 17/2/13.
 */

public class ViewHolderTwo extends com.yjs.recyclerview.adapter.BaseViewHolder<EntityTwo> {
    public ViewHolderTwo(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(EntityTwo model, int position) {
        TextView textView = (TextView) getView(R.id.tv);



    }
}
