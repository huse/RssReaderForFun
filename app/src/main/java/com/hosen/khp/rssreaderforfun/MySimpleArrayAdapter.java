package com.hosen.khp.rssreaderforfun;

/**
 * Created by f1 on 10/27/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    String vv;

    public MySimpleArrayAdapter(Context context, String[] values, String vv) {



        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.vv=vv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.postitem, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.postTitleLabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.postThumb);
        TextView textView2 = (TextView) rowView.findViewById(R.id.postDateLabel);


        textView2.setText("Date" );
        textView.setText(values[position]);


        if (vv.contains("yahoo")) {

            imageView.setImageResource(R.mipmap.yahoo);
        } else if(vv.contains("google")) {
           // imageView.setImageResource(R.mipmap.yahoo);
        }

        return rowView;
    }
}
