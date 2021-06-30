package com.prabhakar.intentsandintentfilters_we;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText email;
    private EditText password;
    private Button button;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid && isUserNameValid) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", userName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.login);
    }

    private boolean isEmailValid() {
        if (email.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            email.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (password.getText().toString().length() >= 6) {
            return true;
        } else {
            password.setError("Password length is less than 6 characters");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (userName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            userName.setError("Username is not valid");
            return false;
        }
    }
}