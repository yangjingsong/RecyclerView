package com.yjs.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.EntityTwo;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.StickyDirection;
import com.yjs.recyclerview.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemDirectionActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_direction);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        List<ChannelEntity> cities = new ArrayList<>();

        ChannelEntity channelEntity1 = new ChannelEntity();
        channelEntity1.setName("北京");
        channelEntity1.setLetter("B");
        cities.add(channelEntity1);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName("大连");
        channelEntity.setLetter("D");
        cities.add(channelEntity);

        ChannelEntity channelEntity6 = new ChannelEntity();
        channelEntity6.setName("大理");
        channelEntity6.setLetter("D");
        cities.add(channelEntity6);
        cities.add(channelEntity6);
        cities.add(channelEntity6);

        ChannelEntity channelEntity3 = new ChannelEntity();
        channelEntity3.setName("广州");
        channelEntity3.setLetter("G");
        cities.add(channelEntity3);
        cities.add(channelEntity3);cities.add(channelEntity3);

        ChannelEntity channelEntity5 = new ChannelEntity();
        channelEntity5.setName("杭州");
        channelEntity5.setLetter("H");
        cities.add(channelEntity5);cities.add(channelEntity5);cities.add(channelEntity5);

        ChannelEntity channelEntity2 = new ChannelEntity();
        channelEntity2.setName("上海");
        channelEntity2.setLetter("S");
        cities.add(channelEntity2);cities.add(channelEntity2);cities.add(channelEntity2);

        ChannelEntity channelEntity4 = new ChannelEntity();
        channelEntity4.setName("深圳");
        channelEntity4.setLetter("S");
        cities.add(channelEntity4);
        cities.add(channelEntity4);
        cities.add(channelEntity4);





        CityAdapter cityAdapter = new CityAdapter(cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cityAdapter);
        recyclerView.addItemDecoration(new StickyDirection(cities,this));

        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    a++;
                }
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("a",a+"");



    }
}
