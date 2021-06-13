package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
    Button bmibutton,bmrbutton,idealbutton,caloriebutton,proteinbutton,tips,tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bmibutton = (Button)findViewById(R.id.bmibutton);
        idealbutton = (Button)findViewById(R.id.idealbutton);
        caloriebutton = (Button)findViewById(R.id.caloriebutton);
        proteinbutton =(Button) findViewById(R.id.proteinbutton);
        tips = (Button) findViewById(R.id.healthtip);
        tracker = (Button)findViewById(R.id.tracker);

        bmibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),BMI.class);
                startActivity(intent);
            }
        });
        idealbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),idealWeight.class);
                startActivity(intent);
            }
        });
        caloriebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BMR.class);
                startActivity(intent);
            }
        });
        proteinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProteinIntake.class);
                startActivity(intent);
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Web.class);
                startActivity(intent);
            }
        });
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Tracker.class);
                startActivity(intent);
            }
        });
    }
}