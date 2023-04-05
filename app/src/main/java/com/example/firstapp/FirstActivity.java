package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    // for button
    Button btn1, btn2, btn3;
    TextView tv1,tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_example);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        tv1=findViewById(R.id.tv_text1);
        tv2=findViewById(R.id.tv_text2);

        tv1.setText("This is textview example");
        tv2.setText(R.string.app_name);
        String txtStr = getString(R.string.app_name);
        String tvStr = btn1.getText().toString();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent is permission
                // sidae pathako vayera sidae bhitra banako Intent object
                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // extra value pathauna parne vayera hami lae naya object banako
                Intent intnet = new Intent(FirstActivity.this, SecondActivity.class);
                intnet.putExtra("DATA", "This is button 2 being redirected");
                intnet.putExtra("INTEGER_VALUE", 1);
                // ava ball start activity ma hamro banako object pahtuane
                startActivity(intnet);
            }
        });
    }
}
