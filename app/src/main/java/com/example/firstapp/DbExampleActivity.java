package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.db.Contact;
import com.example.firstapp.db.ContactDbHelper;

public class DbExampleActivity extends AppCompatActivity {
    private EditText edtName, edtPhone;
    private Button btnSave, btnShow;
    private ContactDbHelper contactDbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_fragment);
        edtName = findViewById(R.id.edt_name);
        edtPhone = findViewById(R.id.edt_phone);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);

        contactDbHelper = new ContactDbHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    Contact contact = new Contact();
                    contact.setName(edtName.getText().toString());
                    contact.setPhone_number(edtPhone.getText().toString());
                    contactDbHelper.addContact(contact);
                    edtName.setText("");
                    edtPhone.setText("");
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DbExampleActivity.this,ContactListActivity.class));
            }
        });
    }


    // for validating fields
    private boolean isValid() {
        if(edtName.getText().toString().isEmpty()){
            edtName.setError("Please Enter name");
            edtName.requestFocus();
            return false;
        }else if(edtPhone.getText().toString().isEmpty()){
            edtPhone.setError("Please the phone number");
            edtPhone.requestFocus();
            return false;
        }
        return true;
    }
}
