package com.example.ricerca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class Activity2 extends AppCompatActivity {

    TextView websiteTextView;
    Button openWebsiteButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        websiteTextView = findViewById(R.id.websiteEditText);
        openWebsiteButton = findViewById(R.id.openWebsite);
        webView = findViewById(R.id.webview);

        Intent intent = getIntent();
        final String websiteString = intent.getStringExtra("website");
        websiteTextView.setText(websiteString);

        openWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient( new WebViewClient());
                webView.loadUrl("https://" + websiteString + ".com");
            }
        });
    }
}