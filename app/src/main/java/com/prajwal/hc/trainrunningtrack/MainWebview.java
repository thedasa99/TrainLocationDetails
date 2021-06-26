package com.prajwal.hc.trainrunningtrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.prajwal.hc.trainrunningtrack.databinding.ActivityMainWebviewBinding;
import com.prajwal.hc.trainrunningtrack.listdata.AppOpenManager;
import com.prajwal.hc.trainrunningtrack.listdata.InterstitialSample;

import java.io.InputStream;
import java.util.Random;

public class MainWebview extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainWebviewBinding binding;
    public Context context;
    Activity myActivity;
    public  WebView myWebView;


    public  String sttncode="";
    public String Locono="";
    public String Direction="ALL";
    String tagstn="TAGSTN",tagloco="TAGLOCO",tagdirection="TAGDIRECTION";

    String LOCOURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/integrationFois/trainRunningDetailLoco.do?hmode=locoDetails&app=&loadID=TAGLOCO&sttnCode=TAGSTN&event=loco";

    String StnURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/IntegrationFois/TrainRunningDetailDirectionAction.do?hmode=fetchRecordsFromFOIS&stn=TAGSTN&dir=TAGDIRECTION";

    String url="https://cms.indianrail.gov.in/TRAINENQ/JSP/integrationFois/trainRunningDetailLoco.do?hmode=loadJSP&app=#";
    private InterstitialAd mInterstitialAd;
    InterstitialSample myIntersitital=new InterstitialSample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = ActivityMainWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context=this.getApplicationContext();
        myActivity=this;

        setSupportActionBar(binding.toolbar);
        Intent intent= getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            sttncode = extras.getString("sttncode");
            Direction = extras.getString("Direction");
            Locono = extras.getString("Locono");
        }

        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {


                    }
                });
        myWebView = (WebView) findViewById(R.id.webview2);
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
                    /*myWebView.loadUrl("javascript:(function() { " +
                            "document.getElementsByTagName('table')[0].style.display='none'; " +
                            "})()");
                            */

                  //  myWebView.setInitialScale(200);
                      injectCSS();

                }
            });



            String html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                  "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">";
          myWebView.loadData(html, "text/html", "utf-8");
            myWebView.loadUrl( url);
            callgetdata(   );


            // String url = i.getStringExtra("url");
           // myWebView.loadUrl( url);


        }catch(Exception e){

        }

    }




    public  void callgetdata(   ){
        //  sttncode="";
        //   Locono="";
        //  Direction="ALL";
        //tagstn="TAGSTN",tagloco="TAGLOCONO",tagdirection="TAGDIRECTION";



        if(Locono.isEmpty()) {
            StnURL = StnURL.replace("TAGSTN", sttncode);
            StnURL = StnURL.replace("TAGDIRECTION", Direction);
            myWebView.loadUrl(StnURL);
            //   Toast.makeText(MainActivity2.this,     ""+StnURL,            Toast.LENGTH_SHORT).show();
        }
        else {
            LOCOURL = LOCOURL.replace("TAGSTN", sttncode);
            LOCOURL = LOCOURL.replace("TAGDIRECTION", Direction);
            LOCOURL = LOCOURL.replace("TAGLOCO", Locono);
            //  Toast.makeText(MainActivity2.this,    ""+LOCOURL,     Toast.LENGTH_SHORT).show();
            myWebView.loadUrl(LOCOURL);
        }

    }


    public void injectCSS() {
        try {
            InputStream inputStream = getAssets().open("style.css");
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
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {

                        Random r = new Random();
                        int random = r.nextInt( 9);

                      if(random%5==0)
                        myIntersitital.showInterstitial(context,myActivity);

                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}