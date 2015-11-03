package com.hosen.khp.rssreaderforfun;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.hosen.khp.rssreaderforfun.data.RssItem;
import com.hosen.khp.rssreaderforfun.listeners.ListListener;
import com.hosen.khp.rssreaderforfun.util.RssReader;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Main application activity.

 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivityw";
    // A reference to the local object
    private MainActivity local;
    EditText editText;
    Button buttonGo, button1, button2, button3,button4,button5,button6,button7,button11,button12,button13,button14,button15,button16
            ,button17,button21,button22,button23,button24,button25,button26,button27;
    GetRSSDataTask task;
    String urlString="";
    String address;

    ImageView imagview;
    String yahoo= "http://news.yahoo.com/rss/";
   // String google = "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";
   // String google = "https://news.google.com/news/feeds?output=rss&q=whatever%20%E2%80%93";
   // String google = "https://news.google.com/news/";
   // String google =  "https://news.google.com/news/feeds?cf=all&ned=us&hl=en&q=education&output=rss";
    String espn =  "http://sports.espn.go.com/espn/rss/news";
    String bbc = "http://feeds.bbci.co.uk/news/world/rss.xml#";
    String cnn = "http://rss.cnn.com/rss/cnn_topstories.rss";
    String msn = "http://rss.msn.com/";
    String reuters = "http://feeds.reuters.com/Reuters/domesticNews?format=xml";
    String disney = "http://feeds.feedburner.com/disney-updates?format=xml";

    String mercedes = "https://www.mercedes-benz.com/en/ressort/mercedes-benz/lifestyle/feed/";
     String porsche = "http://newsroom.porsche.com/rss/en/index.rss";
    String lamborghini = "http://www.lamborghini.com/en/feeds/rss20/lamborghini-news/?cHash=ccbb11a6c6bc01e58261d5cec2a6102d";
    String lexus =  "http://feeds.feedburner.com/lexus-int/news";
    String gm =  "http://media.gm.com/media/us/en/gm/news/jcr:content/righttabsocialmedia/rss.newsrss.html";
    String boxoffice =  "http://pro.boxoffice.com/rss-feeds/news";
    String billboard =  "http://www.billboard.com/articles/rss.xml";

    String microsoft = "http://sxp.microsoft.com/feeds/3.0?tags=msit";
    String directv = "http://forums.directv.com/community/feeds/allcontent?community=10177903";
    String cisco =  "http://www.cisco.com/warp/public/146/news_cisco/data/syndication/rss2/headlinesAndNewsReleases_20.xml?_ga=1.146213555.640832375.1445981931";
    String att =  "http://feeds.feedburner.com/AttAllCategoriesRssFeeds";
    String apple = "http://images.apple.com/main/rss/hotnews/hotnews.rss";
    String Sony = "http://www.sony.net/SonyInfo/News/Press/data/pressrelease_for_top.xml";
    String oracle = "http://www.oracle.com/ocom/groups/public/@ocom/documents/webcontent/196280.xml";



    public static void toastMessage(String s){
        //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
      //  editText.setText("Date");
    }

    /**
     * This method creates main application view
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.activity_main);
        // This code is for add banner
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        imagview = (ImageView)findViewById(R.id.postThumb);
        // Set reference to this activity
        local = this;

        editText = (EditText)findViewById(R.id.textView1);
        editText.setSelection(editText.getText().length());
        taskMethod("http://news.yahoo.com/rss/");
        //task = new GetRSSDataTask();
/*if (!isNetworkConnected()){
    Toast.makeText(getApplicationContext(), "Check internet connection", Toast.LENGTH_LONG).show();
    Log.d("NoNetwork", Thread.currentThread().getName());
}
        // Start download RSS task



        task.execute("http://news.yahoo.com/rss/");

        // Debug the thread name
        Log.d("RssReader", Thread.currentThread().getName());*/

    }
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.button_go:
                taskMethod(editText.getText().toString());

                break;
            case R.id.button1:
                taskMethod(yahoo);
                break;
            case R.id.button2:
                taskMethod(espn);
                break;
            case R.id.button3:
                taskMethod(bbc);
                break;
            case R.id.button4:
                taskMethod(cnn);
                break;
            case R.id.button5:
                taskMethod(msn);
                break;
            case R.id.button6:
                taskMethod(reuters);
                break;
            case R.id.button7:
                taskMethod(disney);
                break;
            case R.id.button11:
                taskMethod(mercedes);
                break;
            case R.id.button12:
                taskMethod(porsche);
                break;
            case R.id.button13:
                taskMethod(lamborghini);
                break;
            case R.id.button14:
                taskMethod(lexus);
                break;
            case R.id.button15:
                taskMethod(gm);
                break;
            case R.id.button16:
                taskMethod(boxoffice);
                break;
            case R.id.button17:
                taskMethod(billboard);
                break;
            case R.id.button21:
                taskMethod(microsoft);
                break;
            case R.id.button22:
                taskMethod(directv);
                break;
            case R.id.button23:
                taskMethod(cisco);
                break;
            case R.id.button24:
                taskMethod(att);
                break;
            case R.id.button25:
                taskMethod(apple);
                break;
            case R.id.button26:
                taskMethod(Sony);
                break;
            case R.id.button27:
                taskMethod(oracle);
                break;

        }



    }
    static Boolean runBoolean =true;
public static void sendError(Exception e){
    runBoolean=false;
    Log.e("IgottheErrormain", e.getMessage());
}
    private void taskMethod(String s) {



        if (isNetworkConnected()){
            urlString = s;
            editText.setText(s);

            task = new GetRSSDataTask();
            task.execute(s);
            try {
                task.get(3000, TimeUnit.MILLISECONDS);
        }
        catch (Exception e){
            task.cancel(true);
            System.out.println("GRDT timeout");
        }
            editText.setSelection(editText.getText().length());
            if (runBoolean==false){
                Toast.makeText(getApplicationContext(), "Error, check connection and URL", Toast.LENGTH_SHORT).show();
            }
            Log.d("RssReaderoclick", Thread.currentThread().getName());
            runBoolean=true;
        }else{
            Toast.makeText(getApplicationContext(), "Check internet connection", Toast.LENGTH_SHORT).show();
            Log.d("NoNetwork", Thread.currentThread().getName());
        }

    }
    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    public Boolean isAvailable() {
        if (isNetworkConnected()){

        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1    www.google.com");

            int returnVal = p1.waitFor();
            boolean reachable = (returnVal == 0);
            if (reachable) {
                System.out.println("Internet access");
                return reachable;
            } else {
                System.out.println("No Internet access");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
        return false;
    }
    private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
        @Override
        protected List<RssItem> doInBackground(String... urls) {



            try {
                //get(4000, TimeUnit.MILLISECONDS);
                // Debug the task thread name
                Log.d("RssReaderdoInBackground", Thread.currentThread().getName());
                // Create RSS reader
                RssReader rssReader = new RssReader(urls[0]);

                // Parse RSS, get items
                return rssReader.getItems();

            } catch (Exception e) {
                Log.e("RssReaderDOINBACKGROUND", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<RssItem> result) {

            // Get a ListView from main view
           ListView itRRItems = (ListView) findViewById(R.id.listMainView);
            int j=0;
            for(RssItem r : result){
                j++;
            }
            String[] rr = new String[j];
            int i=0;
            for(RssItem r : result){

              rr[i]= r.toString();
                i++;
            }

           MySimpleArrayAdapter itemAdapter = new MySimpleArrayAdapter(local, rr,urlString);
            itRRItems.setAdapter(itemAdapter);
            itRRItems.setOnItemClickListener(new ListListener(result, local));

            // Create a list adapter
           // ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
           // itRRItems.setAdapter(adapter);

            // Set list view item click listener
           // itRRItems.setOnItemClickListener(new ListListener(result, local));
        }

        public  Boolean isAvailable() {
            if (isNetworkConnected()){
                Thread tr=new Thread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                try {

                    Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1    www.google.com");

                    int returnVal = p1.waitFor();
                    boolean reachable = (returnVal == 0);

                    if (reachable) {
                        System.out.println("Internet access");
                        return reachable;
                    } else {
                        System.out.println("No Internet access");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
            return false;
        }
    }
}

