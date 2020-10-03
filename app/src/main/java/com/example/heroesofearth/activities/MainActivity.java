package com.example.heroesofearth.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.heroesofearth.Auth;
import com.example.heroesofearth.R;
import com.example.heroesofearth.authactivities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Auth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }
    }
}