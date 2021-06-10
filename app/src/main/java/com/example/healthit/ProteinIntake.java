package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProteinIntake extends AppCompatActivity {
    Button button;
    TextView tv,tvc,tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_intake);
        button = findViewById(R.id.button3);
        tv = findViewById(R.id.textView5);
        tvc = findViewById(R.id.textView13);
        tv3 = findViewById(R.id.gramtext);
      button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.tvprotein);
                float weight = Float.parseFloat(editText.getText().toString());
               Double ff = (float)weight*0.8;
               String val =ff.toString();
               tv.setText(Math.round(ff)+"");
               tv3.setText("grams/day");

            }
        });

        tvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),dialog.class);
                startActivity(intent);
            }
        });
    }
}