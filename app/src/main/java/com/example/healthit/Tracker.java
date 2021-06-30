    package com.example.healthit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.ocpsoft.prettytime.PrettyTime;
import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.Object.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

    public class Tracker extends AppCompatActivity {
        private static final String TAG = "Tracker";
        ImageButton imageButton;
        Button button;
        static TextView timeView;
        EditText editText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tracker);
            LineChart mChart = findViewById(R.id.linechart);
            imageButton = findViewById(R.id.imageButton);
            timeView = findViewById(R.id.textView14);
            button = findViewById(R.id.button5);
            editText = findViewById(R.id.edt1);

            readDate(timeView);
            List<Float> points = null;
            try {
                points = readChartValue();
            } catch (IOException e) {
                Toast.makeText(this, "oops! Somehting went wrong", Toast.LENGTH_SHORT).show();
            }
            createGraph(mChart,points);

            //Chart
            mChart.setDragEnabled(true);
            mChart.setScaleEnabled(false);
            mChart.setBorderColor(new Color().parseColor("#53AE6D"));
            mChart.setDrawGridBackground(false);
            mChart.setGridBackgroundColor(new Color().parseColor("#53AE6D"));

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder
                            = new AlertDialog
                            .Builder(Tracker.this);
                    builder.setMessage("Are you sure you want reset your progress?");
                    builder.setTitle("Warning!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mChart.clear();
                            FileWriter fwOb = null;
                            try {
                                fwOb = new FileWriter("chartdata.text", false);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            PrintWriter pwOb = new PrintWriter(fwOb, false);
                            pwOb.flush();
                            pwOb.close();
                            try {
                                fwOb.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();

                    // Show the Alert Dialog box
                    alertDialog.show();
                }
            });


            button.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    String timeStamp = new SimpleDateFormat("MMMM d, yyyy").format(Calendar.getInstance().getTime());
                    String text = editText.getText().toString();
                    if (text.matches("")) {
                        Toast.makeText(Tracker.this, "Please enter your weight first!", Toast.LENGTH_SHORT).show();
                    } else {
                        writedate(timeStamp);
                        readDate(timeView);
                        String weight = editText.getText().toString();
                        try {
                            writeChartValue(weight+"f");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(Tracker.this, "weight logged! reopen the activity. ", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

        public void createGraph(LineChart mChart,List<Float> points) {
            mChart = findViewById(R.id.linechart);
            ArrayList<Entry> yValues = new ArrayList<>();
            float f =0.5f;

            for (int i = 1; i < points.size(); i++) {
                f+=0.5f;
                yValues.add(new Entry(f, points.get(i)));
                f+=0.5f;
            }
            LineDataSet set1 = new LineDataSet(yValues, "Weight");
            set1.setFillAlpha(110);
            set1.setColor(new Color().parseColor("#3F51B5"));
            set1.setLineWidth(2f);
            set1.setValueTextSize(15f);
            set1.setValueTextColor(new Color().parseColor("#53AE6D"));
            set1.setCircleRadius(5f);

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mChart.setData(data);

        }


        ///////////////////////////////////////////////////////////////////////////////////////////////
        public void readDate(TextView textView) {
            String date = "xyz";
            textView = findViewById(R.id.textView14);
            Context context = Tracker.this;
            try {
                InputStream inputStream = context.openFileInput("lastdate.txt");

                if (inputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((receiveString = bufferedReader.readLine()) != null) {
                        stringBuilder.append(" ").append(receiveString);
                    }
                    inputStream.close();
                    date = stringBuilder.toString();
                    textView.setText("Last Updated: " + date);
                }
            } catch (FileNotFoundException e) {
                Log.e("error", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("error", "Can not read file: " + e.toString());
            }
        }

        public void writedate(String date) {
            Context context = Tracker.this;
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("lastdate.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(date);
                outputStreamWriter.close();
            } catch (IOException e) {
                Toast.makeText(Tracker.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }

        public void writeChartValue(String value) throws FileNotFoundException {
            Context context = Tracker.this;
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("chartvalues.csv", Context.MODE_APPEND));
                outputStreamWriter.write(value+"\n");
                outputStreamWriter.close();
                Toast.makeText(context, "Weight Logged!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(Tracker.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }

        public List<Float> readChartValue() throws IOException {
            Context context = Tracker.this;
            String[] data = new String[10];
            List<Float> list1 = null;
            try {
                InputStream inputStream = context.openFileInput("chartvalues.csv");

                if (inputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((receiveString = bufferedReader.readLine()) != null) {
                        stringBuilder.append("\n").append(receiveString);
                    }
                    inputStream.close();
                    data = stringBuilder.toString().split("\n");
                    list1 = new ArrayList<Float>();
                    if(data == null){
                        list1.add(0f);
                        return list1;
                    }
                    for(int i =1 ; i<data.length; i++){
                        list1.add(Float.parseFloat(data[i-1]));
                    }
                    return list1;

                }
            } catch (FileNotFoundException e) {
                Log.e("error", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("error", "Can not read file: " + e.toString());
            }
            return list1;
        }

    }