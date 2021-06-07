package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class dialog extends AppCompatActivity {
    Spinner spinner1,spinner2,spinner3,spinner4;
    EditText ed1,ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        ed1= findViewById(R.id.editText1);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        ed4 = findViewById(R.id.edittText4);

        ArrayList weightlist = new ArrayList();
        weightlist.add("kg");
        weightlist.add("lbs");
        ArrayList hightlist = new ArrayList();
        hightlist.add("in");
        hightlist.add("cm");
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, weightlist);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, hightlist);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter2);
        spinner4.setAdapter(adapter2);

        Float weight1 = Float.parseFloat(ed1.getText().toString());
        Float weight2 = Float.parseFloat(ed2.getText().toString());
        Float height1 = Float.parseFloat(ed3.getText().toString());
        Float height2 = Float.parseFloat(ed4.getText().toString());


        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    if (spinner1.getSelectedItemPosition()== 0) {
                        ed2.setText(""+weight1);

                    }
                    else if(spinner1.getSelectedItemPosition()==1){
                        ed2.setText(""+weight1*2.205);

                    }
                }
                else if(position==1){
                    if(spinner1.getSelectedItemPosition()==1){
                        ed2.setText(""+weight1);
                    }
                    else if(spinner1.getSelectedItemPosition()==0){
                        ed2.setText(""+weight1/2.205);
                    }
                }
            }
        });

        spinner4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    if (spinner3.getSelectedItemPosition() == 0) {
                        ed2.setText(""+height1);

                    } else if (spinner1.getSelectedItemPosition() == 1) {
                        ed2.setText("" + height1* 2.25);

                    }
                } else if (position == 1) {
                    if (spinner1.getSelectedItemPosition() == 1) {
                        ed2.setText("" + height1);
                    } else if (spinner1.getSelectedItemPosition() == 0) {
                        ed2.setText("" + height1 / 2.25);
                    }
                }
            }



        });



    }
}