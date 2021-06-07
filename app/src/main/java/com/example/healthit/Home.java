package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
    Button bmibutton,bmrbutton,idealbutton,caloriebutton,proteinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bmibutton = findViewById(R.id.bmibutton);
        bmrbutton = findViewById(R.id.caloriebutton);
        idealbutton = findViewById(R.id.idealbutton);
        caloriebutton = findViewById(R.id.caloriebutton);
        proteinbutton = findViewById(R.id.proteinbutton);

        bmibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),BMI.class);
                startActivity(intent);
            }
        });
        bmrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),BMR.class);
                startActivity(intent);
            }
        });
        proteinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ProteinIntake.class);
                startActivity(intent);

            }
        });
        idealbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),idealWeight.class);
                startActivity(intent);
            }
        });
    }
}