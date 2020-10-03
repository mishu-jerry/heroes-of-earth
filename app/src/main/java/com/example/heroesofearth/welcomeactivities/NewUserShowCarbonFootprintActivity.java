package com.example.heroesofearth.welcomeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.heroesofearth.DashboardActivity;
import com.example.heroesofearth.R;
import com.example.heroesofearth.Score;
import com.example.heroesofearth.repository.Repo;

public class NewUserShowCarbonFootprintActivity extends AppCompatActivity {

    TextView sizeTextView;
    Button takeChallengesButton;
    private View.OnClickListener takeChallengesButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(NewUserShowCarbonFootprintActivity.this,
                    DashboardActivity.class));

            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_show_carbon_footprint);

        sizeTextView = findViewById(R.id.textViewFootprintSize);
        takeChallengesButton = findViewById(R.id.buttonTakeChallenges);

        displayFootprintSize();

        takeChallengesButton.setOnClickListener(takeChallengesButtonOnClickListener);
    }

    private void displayFootprintSize() {

        int size = Score.getCompletionRate(Repo.carbonFootprintChallengesList);

        String sizeString = "";

        if (size >= 80) {
            sizeString = "BIG";
        } else if (size >= 40) {
            sizeString = "AVERAGE";
        } else {
            sizeString = "SMALL! Congrats!";
        }

        sizeTextView.setText(sizeString);

        if (size >= 80) sizeTextView.setBackground(getResources()
                .getDrawable(R.drawable.ic_baseline_circle_red_24));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewUserShowCarbonFootprintActivity.this,
                NewUserCalculateCarbonFootprintActivity.class));

        finish();
    }
}