package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.dbdemo.adapter.RecyclerViewAdapter;
import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<contact>contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyDbHandler db= new MyDbHandler(MainActivity.this);
        contactArrayList=new ArrayList<>();
//        listView=findViewById(R.id.listview);
        contact adnan= new contact();
        adnan.setPhonenumber("03346464994");
        adnan.setName("Adnan");
        db.addcontact(adnan);
        contact aslam= new contact();
        aslam.setPhonenumber("03346464994");
        aslam.setName("aslam");
        db.addcontact(aslam);
        aslam.setId(10);
        aslam.setName("ASLAM");
        aslam.setPhonenumber("00000000");
        db.updatecontact(aslam);
        int affecctedrows= db.updatecontact(aslam);
        Log.d("dbaff", "AFFECTED ROW ARE " + affecctedrows);
        List<contact>allcontect=db.getallcontact();
        for (contact contact: allcontect){
            Log.d("dbad" ,"ID "+ contact.getId() +"\n" +
                    "NAME "+ contact.getName() +"\n" +
                    "PHONENUMBER "+ contact.getPhonenumber() +"\n");
            contactArrayList.add(contact);
        }
//        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
//        listView.setAdapter(arrayAdapter);
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}