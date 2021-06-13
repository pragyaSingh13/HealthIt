    package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        mChart = findViewById(R.id.linechart);
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
        yValues.add(new Entry(4,70f));


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

    }
}