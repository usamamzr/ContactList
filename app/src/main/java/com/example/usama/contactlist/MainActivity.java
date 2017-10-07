package com.example.usama.contactlist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) this.findViewById(R.id.list1);

        ArrayList<Contact> arrayList = new ArrayList<>();
        int j= 1;
        arrayList.add(new Contact(1, "Name: 1", Integer.toString(j), "Female"));
        for (int i = 2; i <= 1000; i++) {
            arrayList.add(new Contact(i+1, "Name: "+i, Integer.toString(i), "Male"));
        }

        ContactAdapter contactAdapter = new ContactAdapter (this, arrayList);
        listView.setAdapter(contactAdapter);
    }
}
