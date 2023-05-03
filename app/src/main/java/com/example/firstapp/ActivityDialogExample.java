package com.example.firstapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivityDialogExample extends AppCompatActivity implements View.OnClickListener {
    Button btnAlertDialog, btnDatePicker, btnTimePicker, btnCustomDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        btnAlertDialog = findViewById(R.id.btn_alert);
        btnDatePicker = findViewById(R.id.btn_date);
        btnTimePicker = findViewById(R.id.btn_time);
        btnCustomDialog = findViewById(R.id.btn_custom);

        btnAlertDialog.setOnClickListener(this);
        btnCustomDialog.setOnClickListener(this);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }

    private  void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exaple");
        builder.setMessage("Do you want to continue?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create().show();


    }

    private void showDatePicker(){
        Calendar cal = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String message = "You have selected: " + year + ", " + month + ", " + dayOfMonth;
                Toast.makeText(ActivityDialogExample.this, message, Toast.LENGTH_SHORT).show();
            }
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    private void showTimePicker(){
        Calendar cal = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String message  = "You have selected : " + hourOfDay + ", " + minute;

                Toast.makeText(ActivityDialogExample.this, message, Toast.LENGTH_SHORT).show();
            }
        },cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);

        dialog.show();
    }

    private void showCustomDialog(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_alert:
                showAlertDialog();
                break;
            case R.id.btn_date:
                showDatePicker();
                break;
            case R.id.btn_time:
                showTimePicker();
                break;
            case R.id.btn_custom:
                showCustomDialog();
                break;
        }
    }
}
