package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.firstapp.db.Contact;
import com.example.firstapp.db.ContactAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityVolleyExample extends AppCompatActivity {

    private String URL = "https://run.mocky.io/v3/3db27786-2ed4-4837-ae58-c17a3cf9502f";

    private String URL1 = " https://run.mocky.io/v3/04b8fa8d-81f4-4c72-9d3a-6c9f204fc8f0";
    private String URL2 = "https://run.mocky.io/v3/82d141c5-2cbc-4b94-a1a6-c16289efd47c";
    private TextView tvResult;
    private Button btnStart;
    private RequestQueue queue;
    private StringRequest mStringRequest;

    private JsonObjectRequest mJsonObjectRequest;
    private JsonArrayRequest mJsonArrayRequest;

    private RecyclerView rvContacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_request_activity);
        tvResult = findViewById(R.id.tv_result);
        btnStart = findViewById(R.id.btn_start);
        rvContacts = findViewById(R.id.rv_contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        queue = Volley.newRequestQueue(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volleyStringRequest();
                //volleyJsonObjectRequest();
                volleyJsonArrayRequest();
            }
        });
    }

    private void volleyJsonObjectRequest(){
        mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL1, null, new Response.Listener<JSONObject>() {
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
        mStringRequest = new StringRequest(Request.Method.GET, URL1, new Response.Listener<String>() {
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

    private void volleyJsonArrayRequest(){
        mJsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //tvResult.setText(response.toString());

                // after
                parseJsonArray(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("header", "asdf");
                return param;
            }
        };

        queue.add(mJsonArrayRequest);
    }

    // string ma ako response lae paila jsonobject ma comver gareko
    private void parseJson(String response){
        try{
            ArrayList<Contact> contacts = new ArrayList<>();
            JSONObject jobject = new JSONObject(response);
            JSONArray jsonArray = jobject.getJSONArray("users");

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(obj.getString("id")));
                contact.setName(obj.getString("name"));
                contact.setName(obj.getString("phone_number"));

                contacts.add(contact);
            }
        }catch(Exception e){

        }

    }

    private void parseJsonObject(JSONObject response){
        try{
            ArrayList<Contact> contacts = new ArrayList<>();
            JSONArray jsonArray = response.getJSONArray("users");

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(obj.getString("id")));
                contact.setName(obj.getString("name"));
                contact.setName(obj.getString("phone_number"));

                contacts.add(contact);
            }
        }catch(Exception e){

        }

    }

    // when there is only one object in json
    private void parseSingleJsonObject(JSONObject response){
        try{
            JSONArray jsonArray = response.getJSONArray("users");


                Contact contact = new Contact();
                contact.setId(Integer.parseInt(response.getString("id")));
                contact.setName(response.getString("name"));
                contact.setName(response.getString("phone_number"));


        }catch(Exception e){

        }

    }

    private void parseJsonArray(JSONArray response){
        try{
            ArrayList<Contact> contacts = new ArrayList<>();

            for(int i = 0; i < response.length(); i++){
                JSONObject obj = response.getJSONObject(i);
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(obj.getString("id")));
                contact.setName(obj.getString("name"));
                contact.setPhone_number(obj.getString("phone_number"));

                contacts.add(contact);
            }

            ContactAdapter adapter = new ContactAdapter(this,contacts, null);
            rvContacts.setAdapter(adapter);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
