package com.prajwal.hc.trainrunningtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.prajwal.hc.trainrunningtrack.listdata.BannerAdListener;
import com.prajwal.hc.trainrunningtrack.listdata.InterstitialSample;

import java.io.InputStream;
import java.util.Random;

public class MainNotesDisplaypage extends AppCompatActivity {


    public Context context;
    Activity myActivity;
    public WebView myWebView;

    private InterstitialAd mInterstitialAd;
    InterstitialSample myIntersitital=new InterstitialSample();

    int id;
    public  String idn="";
    public String titlen="";
    public String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes_displaypage);
        context=this.getApplicationContext();
        myActivity=this;
        Intent intent= getIntent();

        Bundle extras = intent.getExtras();
        if(extras != null) {
            idn = extras.getString("id");
            titlen = extras.getString("caption");
            url = extras.getString("url");
        }



        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {


                    }
                });

        myWebView = (WebView) findViewById(R.id.webview1);
        myIntersitital.loadIntersitialads(context,myActivity);

        try{
            myWebView.setWebViewClient(new   WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
                public void onLoadResource (WebView view, String url) {

                }
                public void onPageFinished(WebView view, String url) {
                    view.getSettings().setBuiltInZoomControls(true);
                   view.getSettings().setSupportZoom(true);
                    view.getSettings().setJavaScriptEnabled(true);
                    view.getSettings().setUseWideViewPort(true);

                // injectCSS();
                /*    myWebView.loadUrl("javascript:(function() { " +
                            "var list = document.getElementsByTagName(\"form\")[0];"+
                            " var t2=list.getElementsByTagName(\"table\")[1] ;"+
                            " t2.getElementsByTagName(\"tr\")[1].style.display=\"none\";"+
                            " t2.getElementsByTagName(\"tr\")[2].style.display=\"none\";"+
                            "})()");
*/
                }
            });



            String html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.6\">" +
              //      "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">"+
                    "";
            myWebView.loadData(html, "text/html", "utf-8");
            myWebView.loadUrl( url);



            BannerAdListener. display_banner(   context,   myActivity) ;

        }catch(Exception e){

        }

    }


    public void injectCSS() {
        try {
            InputStream inputStream = getAssets().open("bootstrap.css");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
            myWebView.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var style = document.createElement('style');" +
                    "style.type = 'text/css';" +
                    // Tell the browser to BASE64-decode the string into your script !!!
                    "style.innerHTML = window.atob('" + encoded + "');" +
                    "parent.appendChild(style)" +
                    "})()");
            Log.i("MFT","CSS LOADED WHERE IS MY FRIGHT TRAIN");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:

                        Random r = new Random();
                        int random = r.nextInt( 13);

                        if(random%7==0)
                            myIntersitital.showInterstitial(context,myActivity);

                        finish();

                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}