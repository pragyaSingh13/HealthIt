package com.example.healthit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web = findViewById(R.id.webv);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://apracticalteen.home.blog/2021/06/13/weight-management-tips-for-teens-and-adults-that-actually-work/");
    }
}