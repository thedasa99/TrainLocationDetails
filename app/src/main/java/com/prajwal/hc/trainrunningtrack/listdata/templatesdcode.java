package com.prajwal.hc.trainrunningtrack.listdata;

public class templatesdcode {


    String LOCOURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/integrationFois/trainRunningDetailLoco.do?hmode=locoDetails&app=&loadID=TAGLOCO&sttnCode=TAGSTN&event=loco";
  String StnURL="https://cms.indianrail.gov.in/TRAINENQ/JSP/IntegrationFois/TrainRunningDetailDirectionAction.do?hmode=fetchRecordsFromFOIS&stn=TAGSTN&dir=TAGDIRECTION";

    //Direction ALL,UP,DOWN

    //web  view
    /* final  WebView    myWebView = (WebView)root. findViewById(R.id.webview1);
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
                }
            });

           // String url = i.getStringExtra("url");
            String url="http://www.hcmysore.com/computerlab/";
            myWebView.loadUrl( url);


        }catch(Exception e){

        }*/

}
