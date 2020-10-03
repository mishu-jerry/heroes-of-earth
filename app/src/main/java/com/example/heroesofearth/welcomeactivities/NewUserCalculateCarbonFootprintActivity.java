package com.example.heroesofearth.welcomeactivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.heroesofearth.R;
import com.example.heroesofearth.adapters.DailyChallengesAdapter;
import com.example.heroesofearth.repository.Repo;

public class NewUserCalculateCarbonFootprintActivity extends AppCompatActivity {

    View.OnClickListener calculateButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(NewUserCalculateCarbonFootprintActivity.this,
                    NewUserShowCarbonFootprintActivity.class));

            finish();
        }
    };
    private ListView listView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_carbon_footprint);

        listView = findViewById(R.id.listViewCarbonFootprintChallenges);
        calculateButton = findViewById(R.id.buttonCalculate);

        DailyChallengesAdapter adapter = new DailyChallengesAdapter(
                NewUserCalculateCarbonFootprintActivity.this,
                Repo.carbonFootprintChallengesList);

        listView.setAdapter(adapter);

        calculateButton.setOnClickListener(calculateButtonOnClickListener);
    }

    @Override
    public void onBackPressed() {
        showExitAlertDialog();
    }

    private void showExitAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setMessage("Do want to exit the app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}