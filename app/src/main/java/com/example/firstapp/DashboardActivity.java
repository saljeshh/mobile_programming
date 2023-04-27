package com.example.firstapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Toolbar toolbar;
    Button btnContextMenu, btnPopMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        toolbar = findViewById(R.id.toolbar);
        btnContextMenu = findViewById(R.id.btn_context_menu);
        btnPopMenu = findViewById(R.id.btn_pop_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registerForContextMenu(btnContextMenu);

        btnPopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(view);
            }
        });
    }



    private void showPopMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.dashboard_menu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    // yo override gareko mathi setonmenuitemclike like this gareko vayera , parent class ma type cast gareko
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_edit:
                Toast.makeText(this,"You have clicked Edit", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this,"You have clicked Delete", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }
}
