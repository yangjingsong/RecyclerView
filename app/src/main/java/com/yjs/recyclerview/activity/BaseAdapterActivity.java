package com.yjs.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.EntityTwo;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.baseadapter.BaseRecyclerAdapter;
import com.yjs.recyclerview.baseadapter.Visitable;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        View headerView = LayoutInflater.from(this).inflate(R.layout.item_other,null);
        adapter.addHeaderView(headerView);

        View footerView = LayoutInflater.from(this).inflate(R.layout.item_other,null);
        adapter.addFooterView(footerView);

        SparseArray<Visitable> cities = new SparseArray<>();

        ChannelEntity channelEntity1 = new ChannelEntity();
        channelEntity1.setName("北京");
        channelEntity1.setLetter("B");
        cities.put(0,channelEntity1);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName("大连");
        channelEntity.setLetter("D");
        cities.put(1,channelEntity);

        ChannelEntity channelEntity6 = new ChannelEntity();
        channelEntity6.setName("大理");
        channelEntity6.setLetter("D");
        cities.put(2,channelEntity6);
        cities.put(3,channelEntity6);
        cities.put(4,channelEntity6);

        ChannelEntity channelEntity3 = new ChannelEntity();
        channelEntity3.setName("广州");
        channelEntity3.setLetter("G");
        cities.put(5,channelEntity3);
        cities.put(6,channelEntity3);
        cities.put(7,channelEntity3);

        ChannelEntity channelEntity5 = new ChannelEntity();
        channelEntity5.setName("杭州");
        channelEntity5.setLetter("H");
        cities.put(8,channelEntity5);
        cities.put(9,channelEntity5);
        cities.put(10,channelEntity5);

        ChannelEntity channelEntity2 = new ChannelEntity();
        channelEntity2.setName("上海");
        channelEntity2.setLetter("S");
        cities.put(11,channelEntity2);
        cities.put(12,channelEntity2);
        cities.put(13,channelEntity2);

        ChannelEntity channelEntity4 = new ChannelEntity();
        channelEntity4.setName("深圳");
        channelEntity4.setLetter("S");
        cities.put(14,channelEntity4);
        cities.put(15,channelEntity4);
        cities.put(16,channelEntity4);
        EntityTwo entityTwo = new EntityTwo();
        cities.put(17,entityTwo);
        adapter.setmData(cities);

    }
}
