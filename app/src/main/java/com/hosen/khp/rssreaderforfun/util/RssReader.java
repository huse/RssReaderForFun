package com.hosen.khp.rssreaderforfun.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.hosen.khp.rssreaderforfun.MainActivity;
import com.hosen.khp.rssreaderforfun.data.RssItem;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Class reads RSS data.

 */
public class RssReader  {
    // Our class has an attribute which represents RSS Feed URL
    private String rssUrl;
    /**
     * We set this URL with the constructor
     */
    public RssReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }
    /**
     * Get RSS items. This method will be called to get the parsing process result.
     * @return
     */

    RssParseHandler handler;
    public List<RssItem> getItems() throws Exception {
        try {
            //
            // At first we need to get an SAX Parser Factory object
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Using factory we create a new SAX Parser instance
            SAXParser saxParser = factory.newSAXParser();
            // We need the SAX parser handler object
            handler = new RssParseHandler();
            // We call the method parsing our RSS Feed
            saxParser.parse(rssUrl, handler);
            // The result of the parsing process is being stored in the handler object
        } catch (Exception e) {
            Log.e("getItemMethod", e.getMessage());

            MainActivity.toastMessage("Wrong URL, Check internet connection");
        }
            return handler.getItems();

        //return null;
    }

}
