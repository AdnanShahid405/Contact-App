package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class displayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView nameTextView = findViewById(R.id.displayName);
        nameTextView.setText(name);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView phoneTextView = findViewById(R.id.displayPhone);
        phoneTextView.setText(phone);
    }
}
