package com.example.firstapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLifeCycleExample extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,@Nullable PersistableBundle persistentState){
        super.onCreate(savedInstanceState, persistentState);
        Toast.makeText(this,"onCreate Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy Called",Toast.LENGTH_SHORT).show();
    }


}
