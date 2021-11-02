package com.example.catproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button map = findViewById(R.id.map);
        map.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(intent);
        });

        Button share = findViewById(R.id.share);
        share.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ShareActivity.class);
            startActivity(intent);
        });

    }
}
