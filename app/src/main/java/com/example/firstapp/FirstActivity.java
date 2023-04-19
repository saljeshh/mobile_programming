package com.example.firstapp;

import android.app.Activity;
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
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_example);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        tv1=findViewById(R.id.tv_text1);
        tv2=findViewById(R.id.tv_text2);
        tv3=findViewById(R.id.tv_text3);

        tv1.setText("This is textview example");
        tv2.setText(R.string.app_name);
        String txtStr = getString(R.string.app_name);
        String tvStr = btn1.getText().toString();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent is permission
                // sidae pathako vayera sidae bhitra banako Intent object
                /*startActivity(new Intent(FirstActivity.this,ActivityFragmentTransitionExample.class));*/
                startActivity(new Intent(FirstActivity.this,DashboardActivity.class));
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


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("DATA", "This is new activity result");
                intent.putExtra("INTEGER_VALUE", 400);
                startActivityForResult(intent, 30);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 30){
                if(data != null){
                    if(data.hasExtra("RESULT")){
                        String str = data.getStringExtra("RESULT");
                        tv3.setText(str);
                    }
                }
            }
        }
//            else if (resultCode == Activity.RESULT_CANCELED){
//                super.onActivityResult(requestCode, resultCode, data);
//            }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
