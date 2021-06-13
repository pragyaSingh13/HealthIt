    package com.example.healthit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Map;

public class Tracker extends AppCompatActivity  {
    private static final String TAG="Tracker";
    private LineChart mChart;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        mChart = findViewById(R.id.linechart);
        imageButton = findViewById(R.id.imageButton);
       // mChart.setOnChartGestureListener(Tracker.this);
        //mChart.setOnChartValueSelectedListener(Tracker.this);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        mChart.setBorderColor(android.R.color.white);
        mChart.setDrawGridBackground(false);
        mChart.setGridBackgroundColor(android.R.color.white);
        ArrayList<Entry> yValues= new ArrayList<>();
        yValues.add(new Entry(0,60f));
        yValues.add(new Entry(2,50f));
        yValues.add(new Entry(3,60f));
        yValues.add(new Entry(5,70f));
        yValues.add(new Entry(6,30f));
        yValues.add(new Entry(7,20f));
        yValues.add(new Entry(8,50f));



        LineDataSet set1 = new LineDataSet(yValues,"set1");
        set1.setFillAlpha(110);
        set1.setColor(new Color().parseColor("#3F51B5"));
        set1.setLineWidth(2f);
        set1.setValueTextSize(15f);
        set1.setValueTextColor(new Color().parseColor("#53AE6D"));


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData data =new LineData(dataSets);
        mChart.setData(data);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new AlertDialog.Builder(getApplicationContext()).setTitle("Warning").setMessage("Are you sure you want to reset the chart?").show();
            }
        });

    }
}