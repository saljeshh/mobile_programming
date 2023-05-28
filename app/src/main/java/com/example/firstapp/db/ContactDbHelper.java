package com.example.firstapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ContactDbHelper {
    private DatabaseHelper dbHelper;

    public ContactDbHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void addContact(Contact contact){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("phone", contact.getPhone_number());
        db.insert(DatabaseHelper.TABLE_CONTACT, null, values);
        db.close();
    }
}
