package com.yjs.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import com.yjs.recyclerview.MyLayoutManager;
import com.yjs.recyclerview.R;
import com.yjs.recyclerview.adapter.LayoutManagerAdapter;

public class LayoutManagerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_manager);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        SparseArray<String> array = new SparseArray<>();
        for (int i=0;i<20;i++){
            array.put(i,"item"+i);
        }
        recyclerView.setAdapter(new LayoutManagerAdapter(array));
        recyclerView.setLayoutManager(new MyLayoutManager());

    }
}
