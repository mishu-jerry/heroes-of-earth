package com.example.heroesofearth.authactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.heroesofearth.Auth;
import com.example.heroesofearth.R;
import com.example.heroesofearth.activities.DashboardActivity;
import com.example.heroesofearth.repository.Repo;

public class LoginActivity extends AppCompatActivity {

    View.OnClickListener registerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            finish();
        }
    };

    private EditText emailEditText;
    private EditText passwordEditText;

    View.OnClickListener loginButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email != null && password != null) {
                boolean isSuccessful = Auth.login(email, password);

                if (isSuccessful) {
                    Repo.init();

                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Login failed. Email or password is wrong!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this,
                        "Please enter your email and password!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Button loginButton;
    private TextView registerButtonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        registerButtonTextView = findViewById(R.id.textViewRegisterButton);

        registerButtonTextView.setOnClickListener(registerOnClickListener);

        loginButton.setOnClickListener(loginButtonOnClickListener);

        // Sign Up a demo user
        Auth.signUp(Auth.getDemoUser());

        // Populate the input text fields with the demo user credentials
        emailEditText.setText(Auth.DEMO_EMAIL);
        passwordEditText.setText(Auth.DEMO_PASS);
    }
}