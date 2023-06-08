package com.example.firstapp.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactDbHelper {
    private DatabaseHelper dbHelper;

    public ContactDbHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("phone", contact.getPhone_number());
        db.insert(DatabaseHelper.TABLE_CONTACT, null, values);
        db.close();
    }

    @SuppressLint("Range")
    public Contact getContact(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_CONTACT,
                new String[]{"id", "name", "phone"}, "id =?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Contact contact = new Contact(
                    Integer.parseInt(cursor
                            .getString(cursor.getColumnIndex("id"))),
                    cursor.getString(1),
                    cursor.getString(2));
            return contact;
        }
        return null;
    }

    @SuppressLint("Range")
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_CONTACT;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(
                    cursor.getString(cursor.getColumnIndex("name")));
            contact.setPhone_number(
                    cursor.getString(cursor.getColumnIndex("phone")));
            contactList.add(contact);
            cursor.moveToNext();
        }
        return contactList;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("name", contact.getName());
        val.put("phone", contact.getPhone_number());
        return db.update(DatabaseHelper.TABLE_CONTACT, val,
                "id =?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DatabaseHelper.TABLE_CONTACT,
                "id =?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getContactCount() {
        String countQuery = "SELECT * FROM " + DatabaseHelper.TABLE_CONTACT;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
