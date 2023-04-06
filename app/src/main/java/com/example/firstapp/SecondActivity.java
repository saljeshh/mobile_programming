package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    // make variables for textview
    TextView tv1, tv2;
    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this point to relative layout file bata id haru choose garxa
        // R vaneko resource file ani tesko bhitra layout ma relative vanne file
        setContentView(R.layout.relative_example);

        // receive data from FirstActivity
        tv1 = findViewById(R.id.tv_text1);
        tv2 = findViewById(R.id.tv_text2);
        btnBack = findViewById(R.id.btn_back);

        if(getIntent().hasExtra("DATA")){
            tv1.setText(getIntent().getStringExtra("DATA"));
        }

        if(getIntent().hasExtra("INTEGER VALUE")){
            int val = getIntent().getIntExtra("INTEGER VALUE",0);
            // converting to string from int
            tv2.setText(String.valueOf(val));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing from child to parent
                Intent returnIntent = new Intent();
                returnIntent.putExtra("RESULT", "Successful resrult ok");

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
