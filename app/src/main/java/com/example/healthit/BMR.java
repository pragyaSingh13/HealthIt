package com.example.healthit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class BMR extends AppCompatActivity {
    EditText weighttext, heighttext, agek;
    RadioButton fbtn, mbtn;
    Button button;
    TextView tv,tvc;
    char sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        weighttext = findViewById(R.id.weightxt);
        heighttext = findViewById(R.id.hightxt);
        agek = findViewById(R.id.agetxt);
        fbtn = findViewById(R.id.rbf);
        mbtn = findViewById(R.id.rbm);
        tv = findViewById(R.id.textView6);
        tvc =findViewById(R.id.textView11);
        button = findViewById(R.id.button2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int weight = Integer.parseInt(weighttext.getText().toString());
                int height = Integer.parseInt(heighttext.getText().toString());
                int age = Integer.parseInt(agek.getText().toString());
                if(fbtn.isSelected()){
                    sex = 'f';

                }
                else{
                    sex='m';
                }

                if(sex=='f'){
                   double bmr = 655.1+(4.35*weight/*lbs*/) + (4.7*height/*inch*/) - (4.7*age);
                   String value = Double.toString(Math.round(bmr));
                   tv.setText(value+"cals");
                }
                else{
                    double bmr = 66.47+(6.24*weight)+(12.7*height)-(6.755*age);
                    String val = Double.toString(Math.round(bmr));
                    tv.setText(val+"cals");
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