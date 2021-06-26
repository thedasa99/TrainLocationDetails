package com.prajwal.hc.trainrunningtrack;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.snackbar.Snackbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.prajwal.hc.trainrunningtrack.databinding.ActivityMain2Binding;
import com.prajwal.hc.trainrunningtrack.listdata.AppOpenManager;
import com.prajwal.hc.trainrunningtrack.listdata.BannerAdListener;
import com.prajwal.hc.trainrunningtrack.listdata.InterstitialSample;

import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain2Binding binding;



    public  String sttncode="";
    public String Locono="";
    public String Direction="ALL";
    public  WebView myWebView;
    String tagstn="TAGSTN",tagloco="TAGLOCO",tagdirection="TAGDIRECTION";
    Spinner spinner1;
    TextView sttncodeText,locodnoText;
String TAG="TLD";

    String LOCOURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/integrationFois/trainRunningDetailLoco.do?hmode=locoDetails&app=&loadID=TAGLOCO&sttnCode=TAGSTN&event=loco";

    String StnURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/IntegrationFois/TrainRunningDetailDirectionAction.do?hmode=fetchRecordsFromFOIS&stn=TAGSTN&dir=TAGDIRECTION";

    String url="https://cms.indianrail.gov.in/TRAINENQ/JSP/integrationFois/trainRunningDetailLoco.do?hmode=loadJSP&app=#";
    private static AppOpenManager appOpenManager;
  public Context  context;
    Activity myActivity;

    Application myapplication=getApplication();

    private InterstitialAd mInterstitialAd;
    InterstitialSample myIntersitital=new InterstitialSample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this.getApplicationContext();
        myActivity=this;
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {


                    }
                });
        myIntersitital.loadIntersitialads(context,myActivity);



      /*  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        spinner1 = (Spinner) findViewById(R.id.spinner1);
            myWebView = (WebView) findViewById(R.id.webview1);
        sttncodeText=(TextView)  findViewById(R.id.stntext);
        locodnoText=(TextView)  findViewById(R.id.locotext);


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
                  // injectCSS();
                }
            });



            String html = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
            myWebView.loadData(html, "text/html", "utf-8");
            // String url = i.getStringExtra("url");
           // myWebView.loadUrl( url);


        }catch(Exception e){

        }

        BannerAdListener. display_banner(   context,   myActivity) ;

        Button resetbutton=(Button)findViewById(R.id.buttonreset);
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                sttncodeText .setText("");
                locodnoText.setText("");
            }
        } );

        Button Goclick=(Button)findViewById(R.id.button);
        Goclick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

               // callgetdata(   );
                 Direction=String.valueOf(spinner1.getSelectedItem());
                  sttncode=String.valueOf(sttncodeText.getText()).trim();
                   Locono= String.valueOf(locodnoText.getText()).trim();

                Intent i = new Intent(MainActivity2.this, MainWebview.class);

                i.putExtra("sttncode", sttncode);
                i.putExtra("Direction", Direction);
                i.putExtra("Locono", Locono);
                startActivity(i);


            }
            } );




    }
/*
    @Override
    public boolean onSupportNavigateUp() {
     //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    //  return NavigationUI.navigateUp(navController, appBarConfiguration)
       //         || super.onSupportNavigateUp();
    }

*/


    public  void callgetdata(   ){
           //  sttncode="";
          //   Locono="";
           //  Direction="ALL";
        //tagstn="TAGSTN",tagloco="TAGLOCONO",tagdirection="TAGDIRECTION";


     //   Direction=String.valueOf(spinner1.getSelectedItem());
     //   sttncode=String.valueOf(sttncodeText.getText()).trim();
     //     Locono= String.valueOf(locodnoText.getText()).trim();


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
    private void injectCSS() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



            @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       /* if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        myIntersitital.showInterstitial(context,myActivity);
                        finish();
                    }
                    return true;
            }

        }*/
        return super.onKeyDown(keyCode, event);
    }
}