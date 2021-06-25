package com.prajwal.hc.trainrunningtrack.listdata;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class NativeadsSample {

    private static final String APP_ID ="ca-app-pub-9112953297416111/8692102029";
    // private static final String AD_UNIT_ID = "ca-app-pub-9112953297416111/9945682383";
    private static final String adunitTEST ="ca-app-pub-3940256099942544/2247696110";

    private static final String AD_UNIT_ID ="ca-app-pub-9112953297416111/8692102029";

    public static void display_native(Context context, Activity mA) {
        try {
            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });

            AdLoader adLoader = new AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110")
                    .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                        @Override
                        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                            // Show the ad.
                        }
                    })
                    .withAdListener(new AdListener() {

                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()
                            // Methods in the NativeAdOptions.Builder class can be
                            // used here to specify individual options settings.
                            .build())
                    .build();


        }catch(Exception e){}
    }


}
