package com.prajwal.hc.trainrunningtrack.listdata;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.prajwal.hc.trainrunningtrack.R;

//BannerAdListener.Banner(context, this);
// InterstitialSample.FullScreenAds(context, this);
public class BannerAdListener {
 /** Your ad unit id*/
// private static final String AD_UNIT_ID = "ca-app-pub-9112953297416111/9945682383";
 //private static final String AD_UNIT_ID ="ca-app-pub-9112953297416111/9945682383";
  //  private static final String AD_UNIT_ID ="ca-app-pub-9112953297416111/2346098649";
 /** The log tag. */
 private static final String LOG_TAG = "BannerAdListener";

/*
TLD:

appid:ca-app-pub-9112953297416111~5840187608

ad id openads:ca-app-pub-9112953297416111/9697625845
 */


    private static final String APP_ID ="ca-app-pub-9112953297416111~5840187608";
    // private static final String AD_UNIT_ID = "ca-app-pub-9112953297416111/9945682383";
    private static final String adunitTEST ="ca-app-pub-3940256099942544/6300978111";

    private static final String AD_UNIT_ID ="ca-app-pub-9112953297416111/9697625845";
 /** The view to show the ad. */
 static private AdView adView;





 /** Called when the activity is first created. */
 public static void display_banner( Context con, Activity mA) {
       try{


       // Create an ad.
       adView = mA.findViewById(R.id.adView);;
      // adView.setAdSize(AdSize.BANNER);
      // adView.setAdUnitId(adunitTEST);

       // Add the AdView to the view hierarchy.
     //  LinearLayout layout = (LinearLayout)mA. findViewById(R.id.myads);
     //  layout.addView(adView);


       AdRequest adRequest = new AdRequest.Builder() .build();

       // Start loading the ad in the background.
       adView.loadAd(adRequest);

       }catch(Exception e){}
     }



    public static void BannerM( Context con, Activity mA ) {
        try{

            // Create an ad.
            adView = mA.findViewById(R.id.adView);
            adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
            adView.setAdUnitId(AD_UNIT_ID);


          //  LinearLayout layout = (LinearLayout)mA. findViewById(R.id.myads);
           // layout.addView(adView);

            AdRequest adRequest = new AdRequest.Builder()
                    // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    // .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
                    .build();

            // Start loading the ad in the background.
            adView.loadAd(adRequest);

        }catch(Exception e){}
    }








 /** Gets a string error reason from an error code. */
 private static String getErrorReason(int errorCode) {
   String errorReason = "";
   switch(errorCode) {
     case AdRequest.ERROR_CODE_INTERNAL_ERROR:
       errorReason = "Internal error";
       break;
     case AdRequest.ERROR_CODE_INVALID_REQUEST:
       errorReason = "Invalid request";
       break;
     case AdRequest.ERROR_CODE_NETWORK_ERROR:
       errorReason = "Network Error";
       break;
     case AdRequest.ERROR_CODE_NO_FILL:
       errorReason = "No fill";
       break;
   }
   return errorReason;
 }

}
