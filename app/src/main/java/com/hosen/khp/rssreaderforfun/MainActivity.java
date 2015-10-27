package com.hosen.khp.rssreaderforfun;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hosen.khp.rssreaderforfun.data.RssItem;
import com.hosen.khp.rssreaderforfun.listeners.ListListener;
import com.hosen.khp.rssreaderforfun.util.RssReader;

import java.util.List;





/**
 * Main application activity.

 */
public class MainActivity extends Activity {

    // A reference to the local object
    private MainActivity local;
    EditText editText;
    Button buttonGo, button1, button2, button3,button4,button5,button6,button7,button11,button12,button13,button14,button15,button16
            ,button17,button21,button22,button23,button24,button25,button26,button27;
    GetRSSDataTask task;
    String urlString="";
    String yahoo= "http://news.yahoo.com/rss/";
    String google = "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";
     String cnn = "http://rss.cnn.com/rss/cnn_topstories.rss";
     String msn = "http://rss.msn.com/";
     String apple = "http://images.apple.com/main/rss/hotnews/hotnews.rss";
     String directv = "http://forums.directv.com/community/feeds/allcontent?community=10177903";
    String mercedes = "https://www.mercedes-benz.com/en/ressort/mercedes-benz/lifestyle/feed/";
     String porsche = "http://newsroom.porsche.com/rss/en/index.rss";
    String lamborghini = "http://www.lamborghini.com/en/feeds/rss20/lamborghini-news/?cHash=ccbb11a6c6bc01e58261d5cec2a6102d";
    String Sony = "http://www.sony.net/SonyInfo/News/Press/data/pressrelease_for_top.xml";
    String cisco =  "http://www.cisco.com/warp/public/146/news_cisco/data/syndication/rss2/headlinesAndNewsReleases_20.xml?_ga=1.146213555.640832375.1445981931";
     String gm =  "http://media.gm.com/media/us/en/gm/news/jcr:content/righttabsocialmedia/rss.newsrss.html";
    String lexus =  "http://feeds.feedburner.com/lexus-int/news";
    String reuters = "http://feeds.reuters.com/Reuters/domesticNews?format=xml";
     String att =  "http://feeds.feedburner.com/AttAllCategoriesRssFeeds";
     String microsoft = "http://sxp.microsoft.com/feeds/3.0?tags=msit";
    String bing = "https://www.bing.com/news/search?q=developer&go=Submit&qs=n&form=NWBQBN&pq=developer&sc=8-9&sp=-1&sk=&format=RSS";
    /**
     * This method creates main application view
     */
    public static void toastMessage(String s){
        //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.activity_main);


        // Set reference to this activity
        local = this;

        task = new GetRSSDataTask();

        // Start download RSS task
        editText = (EditText)findViewById(R.id.textView1);
       // editText.setText("http://www.itcuties.com/feed/");
        editText.setSelection(editText.getText().length());
        task.execute("http://feeds2.feedburner.com/androidcentral?format=xml");

        // Debug the thread name
        Log.d("RssReader", Thread.currentThread().getName());

        buttonGo = (Button)findViewById(R.id.button_go);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlString = editText.getText().toString();
                task = new GetRSSDataTask();
                try {
                    task.execute(urlString);
                    Log.d("RssReaderByButton", Thread.currentThread().getName());
                } catch (Exception e) {

                }
            }

        });
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlString = "http://news.yahoo.com/rss/";
                task = new GetRSSDataTask();
                try {
                    Toast.makeText(getApplicationContext(), "http://news.yahoo.com/rss/", Toast.LENGTH_SHORT).show();
                    task.execute(urlString);
                    Log.d("RssReaderByButtonY", Thread.currentThread().getName());

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";

                try {
                    task = new GetRSSDataTask();
                    task.execute(urlString);
                    Log.d("RssReaderByButtonY", Thread.currentThread().getName());

                } catch (Exception e) {

                }


            }

        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Log.d("RssReaderByButtonBStart", Thread.currentThread().getName());


                    // https://www.bing.com/news/?format=RSS.xml

                    task = new GetRSSDataTask();

                    //Toast.makeText(getApplicationContext(), "Bing", Toast.LENGTH_SHORT).show();
                    task.execute(urlString);

                    Log.d("RssReaderByButtonB", Thread.currentThread().getName());
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });
        button4 = (Button)findViewById(R.id.button2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = "http://rss.cnn.com/rss/cnn_topstories.rss";

                    task = new GetRSSDataTask();
                    task.execute(urlString);
                    Log.d("RssReaderBu", Thread.currentThread().getName());




            }

        });

    }

    private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
        @Override
        protected List<RssItem> doInBackground(String... urls) {



            try {
                //Toast.makeText(getApplicationContext(), "doInBackground", Toast.LENGTH_SHORT).show();
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

            // Create a list adapter
            ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
            itRRItems.setAdapter(adapter);

            // Set list view item click listener
            itRRItems.setOnItemClickListener(new ListListener(result, local));
        }


    }
}

