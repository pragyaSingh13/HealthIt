package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class dialog extends AppCompatActivity {
    Spinner spin1,spin2,spin3,spin4;
    EditText ed1,ed2,ed3,ed4;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        spin1 = (Spinner)findViewById(R.id.spinner2);
        spin2 = (Spinner)findViewById(R.id.spinner1);
        spin3 = (Spinner)findViewById(R.id.spinner3);
        spin4 = (Spinner)findViewById(R.id.spinner4);
        ed1 = findViewById(R.id.et1);
        ed2 = findViewById(R.id.et2);
        ed3 = findViewById(R.id.et3);
        ed4 = findViewById(R.id.et4);

        ArrayList weightlist = new ArrayList();
        weightlist.add("kg");
        weightlist.add("lbs");
        ArrayList hightlist = new ArrayList();
        hightlist.add("in");
        hightlist.add("cm");
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, weightlist);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hightlist);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        spin2.setAdapter(adapter1);
        spin3.setAdapter(adapter2);
        spin4.setAdapter(adapter2);

        String s1 = ed1.getText().toString();
        String s2 = ed2.getText().toString();
        float weight1 = Float.parseFloat(s1);
        float weight2 = Float.parseFloat(s2);
        String s3 = ed3.getText().toString();
        String s4 = ed4.getText().toString();
        float height1 = Float.parseFloat(s3);
        float height2 = Float.parseFloat(s4);

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    if (spin1.getSelectedItemPosition()== 0) {
                        ed2.setText(""+weight1);

                    }
                    else if(spin1.getSelectedItemPosition()==1){
                        ed2.setText(""+weight1*2.205);

                    }
                }
                else if(position==1){
                    if(spin1.getSelectedItemPosition()==1){
                        ed2.setText(""+weight1);
                    }
                    else if(spin1.getSelectedItemPosition()==0){
                        ed2.setText(""+weight1/2.205);
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(dialog.this, "PLease  select a unit", Toast.LENGTH_SHORT).show();

            }
        });


        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    if (spin3.getSelectedItemPosition() == 0) {
                        ed4.setText(""+height1);

                    } else if (spin3.getSelectedItemPosition() == 1) {
                        ed4.setText("" + height1* 2.25);

                    }
                } else if (position == 1) {
                    if (spin3.getSelectedItemPosition() == 1) {
                        ed4.setText("" + height1);
                    } else if (spin3.getSelectedItemPosition() == 0) {
                        ed4.setText("" + height1 / 2.25);
                        ed4.setText("60065");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(dialog.this, "Please select a unit", Toast.LENGTH_SHORT).show();

            }
        });


    }
}







