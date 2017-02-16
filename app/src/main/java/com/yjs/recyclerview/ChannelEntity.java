package com.yjs.recyclerview;

import com.yjs.recyclerview.baseadapter.TypeFactory;
import com.yjs.recyclerview.baseadapter.Visitable;

/**
 * Created by yangjingsong on 17/p1/3.
 */

public class ChannelEntity implements Visitable{
    int id;
    String name;
    String letter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
