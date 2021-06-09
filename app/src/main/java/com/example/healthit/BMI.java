package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
EditText weighttext, highttext;
Button button;
TextView textView,convert,chart;
    public float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weighttext = findViewById(R.id.weighttext);
        highttext = findViewById(R.id.heighttext);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView3);
        convert = findViewById(R.id.textView7);
        chart = findViewById(R.id.tv20);
        chart.setTextColor(Color.parseColor("#FF0909"));

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),dialog.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            AlertDialog alertDialog = new AlertDialog.Builder(BMI.this).create();


            @Override
            public void onClick(View v) {
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });

                try {
                    float height = Float.parseFloat(highttext.getText().toString());
                    float weight = Float.parseFloat(weighttext.getText().toString());
                    bmi = weight / (height * height);
                    textView.setText(""+bmi);


                }catch(Exception e){
                    alertDialog.setMessage("Some error has occured :/");

                }


            }
        });
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), com.example.healthit.chart.class);
                intent.putExtra("key1",bmi);
                startActivity(intent);
            }
        });




    }
}