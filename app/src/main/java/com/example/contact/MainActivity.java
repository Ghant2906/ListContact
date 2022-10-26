package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<String> contactArrayList;
    ArrayAdapter<String> adapter;
    ArrayList<Integer> idContactList;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = (ListView) findViewById(R.id.listViewContact);
        contactArrayList = new ArrayList<>();
        idContactList = new ArrayList<>();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, 0);

        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor = contentResolver.query(uri, new String[]{ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts._ID}, null, null, null);
        if(cursor.getCount()>0)
            while(cursor.moveToNext()){
                contactArrayList.add(new String(cursor.getString((cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)))));
                idContactList.add(cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
            }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactArrayList);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idContact = idContactList.get(position);
                Intent intent = new Intent(MainActivity.this, DetailContact.class);
                intent.putExtra("idContact", idContact);
                startActivity(intent);
            }
        });
    }
}