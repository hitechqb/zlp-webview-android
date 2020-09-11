package com.hoangld.zlp_android_appweb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblTitle;
    WebView webView;
    Button btnDocs, btnMyWeb;
    public static final String URL_DOCS = "https://docs.zalopay.vn/docs/gateway/demo.html";
    public static final String URL_MY_WEB = "http://172.20.10.4:8080/";

    private void BindView() {
        lblTitle = findViewById(R.id.lblTitle);
        webView =  findViewById(R.id.wbzlp);
        btnDocs = findViewById(R.id.btnDocs);
        btnMyWeb = findViewById(R.id.btnMyWeb);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindView();
        WebViewWithDomainDocs();
        WebViewWithDomainMySite();
        LoadWebView(URL_DOCS);
    }

    private void WebViewWithDomainDocs(){
        btnDocs.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                LoadWebView(URL_DOCS);
            }
        });
    }

    private void WebViewWithDomainMySite(){
        btnMyWeb.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
               LoadWebView(URL_MY_WEB);
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void LoadWebView(String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().getLoadWithOverviewMode();
        webView.loadUrl(url);
    }
}