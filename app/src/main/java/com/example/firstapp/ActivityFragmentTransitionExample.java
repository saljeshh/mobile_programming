package com.example.firstapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFragmentTransitionExample extends AppCompatActivity {
    Button btnFirst,btnSecond;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transition_example);
        btnFirst= findViewById(R.id.btn_first);
        btnSecond = findViewById(R.id.btn_second);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentFirst())
                        .commit();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,new FragmentSecond("Text testing for the ok"))
                        .commit();
            }
        });
    }
}
