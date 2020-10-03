package com.example.heroesofearth.welcomeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.heroesofearth.Auth;
import com.example.heroesofearth.R;
import com.example.heroesofearth.pojos.User;
import com.example.heroesofearth.repository.Repo;

public class CompleteRegistrationActivity extends AppCompatActivity {

    private EditText countryEditText;
    private EditText ageEditText;
    View.OnClickListener doneButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String country = countryEditText.getText().toString().trim();
            String ageString = ageEditText.getText().toString().trim();

            try {
                int age = Integer.parseInt(ageString);
                User user = Auth.getCurrentUser();
                user.setLocation(country);
                user.setAge(age);

                Repo.init();

                startActivity(new Intent(CompleteRegistrationActivity.this,
                        NewUserCalculateCarbonFootprintActivity.class));
                finish();
            } catch (Exception e) {
                Toast.makeText(CompleteRegistrationActivity.this,
                        "Age must be a number!", Toast.LENGTH_SHORT).show();
            }
        }
    };
    private Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_registration);

        countryEditText = findViewById(R.id.editTextCountry);
        ageEditText = findViewById(R.id.editTextAge);
        doneButton = findViewById(R.id.buttonCompleteRegistrationDone);

        doneButton.setOnClickListener(doneButtonOnClickListener);
    }
}