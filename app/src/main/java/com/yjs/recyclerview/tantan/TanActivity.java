package com.yjs.recyclerview.tantan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.yjs.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class TanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        List<Integer> urls = new ArrayList<>();
        urls.add(R.mipmap.p1);
        urls.add(R.mipmap.p2);
        urls.add(R.mipmap.p3);
        urls.add(R.mipmap.p4);
        urls.add(R.mipmap.p5);
        urls.add(R.mipmap.p6);
        TanAdapter adapter  = new TanAdapter(urls);

        recyclerView.setLayoutManager(new TanLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TanItemTouchHelperCallback(this,urls,adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }
}
