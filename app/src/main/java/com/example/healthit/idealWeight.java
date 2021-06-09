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
        tv  =findViewById(R.id.textView4);
        tvc = findViewById(R.id.textView12);

        button.setOnClickListener(new View.OnClickListener() {
            char sex;
            @Override
            public void onClick(View v) {
                Float height = Float.parseFloat(heighttext.getText().toString());
                double hincm = (float) height/2.54;

                if(fbtn.isSelected()){
                     sex= 'f';
                }
                else{
                    sex = 'm';
                }
                Float ideal;
                if(sex=='f'){
                    ideal = height-100-((height-150)/2);
                    String val = ideal.toString();
                    tv.setText(val+"kg");
                }
                else if(sex =='m'){
                    ideal = height-100-((height-150)/4);
                    String val = ideal.toString();
                    tv.setText(val+"kg");
                }
                else{
                    Toast.makeText(idealWeight.this, "Select your gender first", Toast.LENGTH_SHORT).show();
                }

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