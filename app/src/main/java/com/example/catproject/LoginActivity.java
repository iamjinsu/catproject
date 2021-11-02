package com.example.catproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
            startActivity(intent);
        });

        TextView register = findViewById(R.id.join);
        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
            startActivity(intent);
        });

    }
}