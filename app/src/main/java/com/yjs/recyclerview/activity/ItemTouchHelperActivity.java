package com.yjs.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.yjs.recyclerview.ChannelEntity;
import com.yjs.recyclerview.adapter.GridRecyclerViewAdapter;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.RecyclerItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelperActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<ChannelEntity> myChannels = new ArrayList<>(), otherChannels = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ChannelEntity channelEntity = new ChannelEntity();
            channelEntity.setId(i);
            channelEntity.setName("已选" + i);
            myChannels.add(channelEntity);
            ChannelEntity otherEntity = new ChannelEntity();
            otherEntity.setId(i);
            otherEntity.setName("未选" + i);
            otherChannels.add(otherEntity);
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelperCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
        final GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(myChannels, otherChannels,itemTouchHelper);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int realPosition = adapter.getItemViewType(position);
                if (realPosition == GridRecyclerViewAdapter.MY_CHANNEL_NAME || realPosition == GridRecyclerViewAdapter.OTHER_CHANNEL_NAME) {
                    return 4;
                } else {
                    return 1;
                }

            }
        });
        recyclerView.setLayoutManager(manager);




    }
}
