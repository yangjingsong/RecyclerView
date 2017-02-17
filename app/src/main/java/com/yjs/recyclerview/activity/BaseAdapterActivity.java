package com.yjs.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.EntityTwo;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.baseadapter.BaseRecyclerAdapter;
import com.yjs.recyclerview.baseadapter.BaseModel;

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

        List<BaseModel> cities = new ArrayList<>();

        ChannelEntity channelEntity1 = new ChannelEntity();
        channelEntity1.setName("北京");
        channelEntity1.setLetter("B");
        cities.add(0,channelEntity1);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName("大连");
        channelEntity.setLetter("D");
        cities.add(1,channelEntity);

        ChannelEntity channelEntity6 = new ChannelEntity();
        channelEntity6.setName("大理");
        channelEntity6.setLetter("D");
        cities.add(2,channelEntity6);
        cities.add(3,channelEntity6);
        cities.add(4,channelEntity6);

        ChannelEntity channelEntity3 = new ChannelEntity();
        channelEntity3.setName("广州");
        channelEntity3.setLetter("G");
        cities.add(5,channelEntity3);
        cities.add(6,channelEntity3);
        cities.add(7,channelEntity3);

        ChannelEntity channelEntity5 = new ChannelEntity();
        channelEntity5.setName("杭州");
        channelEntity5.setLetter("H");
        cities.add(8,channelEntity5);
        cities.add(9,channelEntity5);
        cities.add(10,channelEntity5);

        ChannelEntity channelEntity2 = new ChannelEntity();
        channelEntity2.setName("上海");
        channelEntity2.setLetter("S");
        cities.add(11,channelEntity2);
        cities.add(12,channelEntity2);
        cities.add(13,channelEntity2);

        ChannelEntity channelEntity4 = new ChannelEntity();
        channelEntity4.setName("深圳");
        channelEntity4.setLetter("S");
        cities.add(14,channelEntity4);
        cities.add(15,channelEntity4);
        cities.add(16,channelEntity4);
        EntityTwo entityTwo = new EntityTwo();
        cities.add(17,entityTwo);
        adapter.loadData(cities);

    }
}
