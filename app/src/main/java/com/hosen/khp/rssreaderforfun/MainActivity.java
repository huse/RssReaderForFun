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
                Log.d("RssReader By Button", Thread.currentThread().getName());
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
                    task.execute(variable);
                    Log.d("RssReader By ButtonY", Thread.currentThread().getName());
                } catch (Exception e) {

                }
            }

        });
        buttonGoogle = (Button)findViewById(R.id.buttonG);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = "http://news.google.com/rss/";

                try {
                    task = new GetRSSDataTask();
                    task.execute(variable);
                    Log.d("RssReader By ButtonY", Thread.currentThread().getName());

                } catch (Exception e) {

                }


            }

        });
        buttonBing = (Button)findViewById(R.id.buttonB);
        buttonBing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable = "http://api.search.live.com/rss.aspx?source=web&query=sushi+los%20angeles";
                task = new GetRSSDataTask();
                try{
                task.execute(variable);
                Log.d("RssReader By ButtonY", Thread.currentThread().getName());
            }catch (Exception e){

            }
            }

        });
    }

    private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
        @Override
        protected List<RssItem> doInBackground(String... urls) {

            // Debug the task thread name
            Log.d("RssReader", Thread.currentThread().getName());

            try {
                // Create RSS reader
                RssReader rssReader = new RssReader(urls[0]);

                // Parse RSS, get items
                return rssReader.getItems();

            } catch (Exception e) {
                Log.e("RssReader", e.getMessage());
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

