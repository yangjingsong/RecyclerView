package com.yjs.recyclerview;


import com.yjs.recyclerview.baseadapter.TypeFactory;
import com.yjs.recyclerview.baseadapter.Visitable;

/**
 * Created by yangjingsong on 17/2/13.
 */

public class EntityTwo implements Visitable {
    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
