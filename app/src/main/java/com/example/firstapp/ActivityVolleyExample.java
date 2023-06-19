package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ActivityVolleyExample extends AppCompatActivity {

    private String URL = "https://run.mocky.io/v3/3db27786-2ed4-4837-ae58-c17a3cf9502f";
    private TextView tvResult;
    private Button btnStart;
    private RequestQueue queue;
    private StringRequest mStringRequest;

    private JsonObjectRequest mJsonObjectRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_request_activity);
        tvResult = findViewById(R.id.tv_result);
        btnStart = findViewById(R.id.btn_start);

        queue = Volley.newRequestQueue(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volleyStringRequest();
                volleyJsonObjectRequest();
            }
        });
    }

    private void volleyJsonObjectRequest(){
        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tvResult.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(mJsonObjectRequest);
    }

    private void volleyStringRequest() {
        mStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvResult.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(mStringRequest);
    }
}
