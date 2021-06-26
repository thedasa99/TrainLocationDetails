 package com.prajwal.hc.trainrunningtrack.listdata;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


 public class InterstitialSample {
   /**
    * The log tag.
    */
   private static final String LOG_TAG = "DfpInterstitialSample";

   /**
    * The interstitial ad unit id. Replace with your ad unit to test your interstitials.
    * ca-app-pub-9112953297416111/2422415585
    *
    *  where is my fright train
    * appid:ca-app-pub-9112953297416111~5840187608
    */


   private static final String adunittest = "ca-app-pub-3940256099942544/1033173712";
   //tld my train
   private static final String AD_UNIT_ID = "ca-app-pub-9112953297416111/6554503474";

   /**
    * Button text values for the interstitial show button.
    */
   private static final String TEXT_NOT_READY = "Interstitial Not Ready";
   private static final String TEXT_LOADING = "Loading Interstitial...";
   private static final String TEXT_SHOW = "Show Interstitial";
   private static final String TEXT_FAILED_TO_LOAD = "Ad Failed to Load";


   static int AdsDelay = 50000;


   public   InterstitialAd mInterstitialAd;

   /* use
   step 1: initializeInterstitial

   step 2:showInterstitial();


   */
   String TAG="TLD";
    public  void loadIntersitialads (Context con, Activity mA){

      AdRequest adRequest = new AdRequest.Builder().build();
      InterstitialAd.load(mA,"ca-app-pub-9112953297416111/6554503474", adRequest, new InterstitialAdLoadCallback() {
        @Override
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
          // The mInterstitialAd reference will be null until
          // an ad is loaded.
          mInterstitialAd = interstitialAd;
        //  Log.i(TAG, "onAdLoaded");
        }

        @Override
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
          // Handle the error
          Log.i(TAG, loadAdError.getMessage());
          mInterstitialAd = null;
        }
      });
    }


   public static void FullInterstitalAds(Context con, Activity mA) {

   }

   public void showInterstitial( Context con,Activity mA) {

     // Show the ad if it's ready. Otherwise toast and restart the game.

     if (mInterstitialAd != null ) {
       mInterstitialAd.show(mA);
     } else {
       //Toast.makeText(mA, "Ad did not load", Toast.LENGTH_SHORT).show();

     }
   }
 }