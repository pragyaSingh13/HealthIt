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

        fbtn = findViewById(R.id.radioButton);
        mbtn = findViewById(R.id.radioButton4);
        tv  =findViewById(R.id.tv22);
        tvc = findViewById(R.id.textView12);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heighttext = (EditText)findViewById(R.id.high);
                float height = Float.parseFloat(heighttext.getText().toString());
                float temp = 0;
                if(fbtn.isChecked()){
                    if(height<=60){
                        tv.setText("49kg");
                    }
                    else if(height<48){
                        Toast.makeText(idealWeight.this, "Please enter a valid adult height", Toast.LENGTH_LONG).show();
                    }
                    else{
                        tv.setText(""+(((height-60)*1.7)+49)+"kg");
                    }

                }
                else if(mbtn.isChecked()){

                    if(height<=60){
                        tv.setText("50kg");
                    }
                    else if(height<48){
                        tv.setText("Please enter a valid adult height");
                    }
                    else{
                        tv.setText(""+(((height-60)*1.9)+50)+"kg");
                    }
                }
                else{
                    Toast.makeText(idealWeight.this, "Please select your gender first" +
                            "", Toast.LENGTH_SHORT).show();
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