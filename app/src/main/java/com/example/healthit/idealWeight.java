package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class idealWeight extends AppCompatActivity {
    Button button;
    EditText heighttext;
    RadioButton fbtn,mbtn;
    TextView tv,tvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);
        button = findViewById(R.id.button4);
        heighttext = findViewById(R.id.high);
        fbtn = findViewById(R.id.radioButton);
        mbtn = findViewById(R.id.radioButton4);
        tv  =findViewById(R.id.tv22);
        tvc = findViewById(R.id.textView12);


        tvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),dialog.class);
                startActivity(intent);
            }
        });
    }
}