package com.example.firstapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityListExample extends AppCompatActivity {
    ListView lvData;
    private ListGridAdapter mAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);
        lvData = findViewById(R.id.ll_list);
        String[] a = {"ram", "shyam", "hari", "gita", "sita"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rv_list_item_row, R.id.tv_info, a);
        // this is default adapter ==>   lvData.setAdapter(adapter);
        // now using custom adapter
        ArrayList<ListData> listValue = new ArrayList<>();
        listValue.add(new ListData("", "Saljesh"));
        listValue.add(new ListData("", "saugat"));
        listValue.add(new ListData("", "rohan"));
        listValue.add(new ListData("", "kushal"));
        listValue.add(new ListData("", "shirish"));
        listValue.add(new ListData("", "sulove"));
        listValue.add(new ListData("", "dog"));


        mAdapter = new ListGridAdapter(this,listValue);
        lvData.setAdapter(mAdapter);
    }
}
