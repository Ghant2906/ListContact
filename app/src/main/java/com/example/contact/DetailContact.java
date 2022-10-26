package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    TextView txtTen, txtSDT;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        txtTen = (TextView) findViewById(R.id.textViewTen);
        txtSDT = (TextView) findViewById(R.id.textViewSDT);

        Intent intent = getIntent();
        int id = intent.getIntExtra("idContact", 0);

        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor= contentResolver.query(uri, new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                ContactsContract.Contacts._ID + " = ?",new String[]{String.valueOf(id)},
                null);

        if(cursor.getCount()>0)
            while(cursor.moveToNext()){
                    txtTen.setText((cursor.getString((cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)))));
                    txtSDT.setText((cursor.getString((cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))));
            }
    }
}