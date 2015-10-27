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
    Button button1, buttonYahoo,buttonGoogle,buttonBing;
    GetRSSDataTask task;
    /**
     * This method creates main application view
     */
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
        editText.setText("http://www.itcuties.com/feed/");
        task.execute("http://feeds2.feedburner.com/androidcentral?format=xml");

        // Debug the thread name
        Log.d("RssReader", Thread.currentThread().getName());

        button1= (Button)findViewById(R.id.button11);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = editText.getText().toString();
                task = new GetRSSDataTask();
                try{
                task.execute(variable);
                Log.d("RssReaderByButton", Thread.currentThread().getName());
                }catch (Exception e){

                }
            }

        });
        buttonYahoo = (Button)findViewById(R.id.buttonY);
        buttonYahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = "http://news.yahoo.com/rss/";
                task = new GetRSSDataTask();
                try {
                    Toast.makeText(getApplicationContext(), "http://news.yahoo.com/rss/", Toast.LENGTH_SHORT).show();
                    task.execute(variable);
                    Log.d("RssReaderByButtonY", Thread.currentThread().getName());

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });
        buttonGoogle = (Button)findViewById(R.id.buttonG);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";

                try {
                    task = new GetRSSDataTask();
                    task.execute(variable);
                    Log.d("RssReaderByButtonY", Thread.currentThread().getName());

                } catch (Exception e) {

                }


            }

        });
        buttonBing = (Button)findViewById(R.id.buttonB);
        buttonBing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    Log.d("RssReaderByButtonBStart", Thread.currentThread().getName());
                    String variable = "https://www.bing.com/news/?format=RSS";
                    task = new GetRSSDataTask();
                    //Toast.makeText(getApplicationContext(), "Bing", Toast.LENGTH_SHORT).show();
                    task.execute(variable);

                    Log.d("RssReaderByButtonB", Thread.currentThread().getName());
            }catch (Exception e){

                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
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

