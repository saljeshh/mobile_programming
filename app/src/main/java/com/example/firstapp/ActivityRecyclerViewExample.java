package com.example.firstapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityRecyclerViewExample extends AppCompatActivity {
    RecyclerView rvData;
    RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycle_view_example);
        rvData = findViewById(R.id.rv_recycler);
      rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
       // rvData.setLayoutManager(new GridLayoutManager(this,22));

        ArrayList<ListData> data = new ArrayList<>();
        data.add(new ListData("", "Test 1"));
        data.add(new ListData("", "Test 2"));
        data.add(new ListData("", "Test 3"));
        data.add(new ListData("", "Test 4"));
        data.add(new ListData("", "Test 5"));
        data.add(new ListData("", "Test 6"));
        data.add(new ListData("", "Test 7"));
        data.add(new ListData("", "Test 8"));
        data.add(new ListData("", "Test 9"));
        data.add(new ListData("", "Test 10"));

        mAdapter = new RecyclerAdapter(this,data);
        //rvData.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rvData.setAdapter(mAdapter);
    }
}
