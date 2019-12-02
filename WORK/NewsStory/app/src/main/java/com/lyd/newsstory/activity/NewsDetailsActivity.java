package com.lyd.newsstory.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lyd.newsstory.R;
import com.lyd.newsstory.ui.base.BaseActivity;
import java.util.ArrayList;


public class NewsDetailsActivity extends BaseActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    WebView webText;
    ImageView ivImage;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        //toolbar =findViewById(R.id.toolbar);
        collapsingToolbar =findViewById(R.id.collapsing_toolbar);
        ivImage =findViewById(R.id.ivImage);
        webText =findViewById(R.id.web_text);
        //toolbar.setTitle("新闻详情");
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      /*  toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/

        //新页面接收数据
        Bundle bundle =this.getIntent().getExtras();
        //接收name值
        final ArrayList<String> data =bundle.getStringArrayList("data");
        Log.i("url", data.get(0));
        WebSettings webSettings =webText.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webText.loadUrl(data.get(1));
        webText.setWebViewClient(new WebViewClient(){
            //已加载
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //编写 javaScript方法
//                String javascript = "javascript:function clearBody(){" +
//                        "document.getElementsByTagName('head')[0].innerHTML=\"\";" +
//                        "}";

                //创建方法
                //view.loadUrl(javascript);

                //加载方法
                // view.loadUrl("javascript:clearBody();");
            }
        });
        Glide.with(this)
                .load(data.get(0))
                .error(R.drawable.wallpaper)
                .fitCenter()
                .into(ivImage);
    }
}
