package com.example.firstapp;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityGridExample extends AppCompatActivity {
    GridView gridView;
    private ListGridAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grid_example);
        gridView= findViewById(R.id.ll_grid_view);
        ArrayList<ListData> listValue = new ArrayList<>();
        listValue.add(new ListData("", "Test 1"));
        listValue.add(new ListData("", "Test 2"));
        listValue.add(new ListData("", "Test 3"));
        listValue.add(new ListData("", "Test 4"));
        listValue.add(new ListData("", "Test 5"));
        listValue.add(new ListData("", "Test 6"));
        mAdapter = new ListGridAdapter(this,listValue);
        gridView.setAdapter(mAdapter);
    }
}
