package com.prabhakar.intentsandintentfilters_we;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {
    private TextView greet_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        greet_user = findViewById(R.id.greet);
        Intent intent = getIntent();
        String greeting = intent.getStringExtra("username");
        greet_user.setText(greeting);
    }
}