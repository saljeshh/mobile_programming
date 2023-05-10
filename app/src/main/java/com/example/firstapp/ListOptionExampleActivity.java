package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListOptionExampleActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnList, btnGrid, btnRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_option_activity);

        btnList = findViewById(R.id.btn_list);
        btnGrid = findViewById(R.id.btn_grid);
        btnRecyclerView = findViewById(R.id.btn_recycler);

        btnList.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_list:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityListExample.class));
                break;

            case R.id.btn_grid:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityGridExample.class));
                break;

            case R.id.btn_recycler:
                startActivity(new Intent(ListOptionExampleActivity.this, ActivityRecyclerViewExample.class));
                break;
        }
    }
}
