package com.example.catproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Button mypage = findViewById(R.id.mypage);
        mypage.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
            startActivity(intent);
        });

        Button enrollment = findViewById(R.id.enrollment);
        enrollment.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EnrollmentActivity.class);
            startActivity(intent);
        });
    }
}
