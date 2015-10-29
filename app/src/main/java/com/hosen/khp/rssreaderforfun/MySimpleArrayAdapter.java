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
            textView2.setText("Yahoo");
        } else if(vv.contains("espn")) {
            imageView.setImageResource(R.mipmap.espn);
        }else if(vv.contains("bbc")) {
            imageView.setImageResource(R.mipmap.bbc);
        }else if(vv.contains("cnn")) {
            imageView.setImageResource(R.mipmap.cnn2);
        }else if(vv.contains("msn")) {
            imageView.setImageResource(R.mipmap.msn);
        }else if(vv.contains("reuters")) {
            imageView.setImageResource(R.mipmap.reuters2);
        }else if(vv.contains("disney")) {
            imageView.setImageResource(R.mipmap.disney);
        }else if(vv.contains("mercedes")) {
            imageView.setImageResource(R.mipmap.benz);
        }else if(vv.contains("porsche")) {
            imageView.setImageResource(R.mipmap.porche);
        }else if(vv.contains("lamborghini")) {
            imageView.setImageResource(R.mipmap.lamborgini);
        }else if(vv.contains("lexus")) {
            imageView.setImageResource(R.mipmap.lexus);
        }else if(vv.contains("gm")) {
            imageView.setImageResource(R.mipmap.gm2);
        }else if(vv.contains("boxoffice")) {
            imageView.setImageResource(R.mipmap.boxoffice);
        }else if(vv.contains("billboard")) {
            imageView.setImageResource(R.mipmap.billboard);
        }else if(vv.contains("microsoft")) {
            imageView.setImageResource(R.mipmap.microsoft);
        }else if(vv.contains("directv")) {
            imageView.setImageResource(R.mipmap.directv);
        }else if(vv.contains("cisco")) {
            imageView.setImageResource(R.mipmap.cisco);
        }else if(vv.contains("Att")) {
            imageView.setImageResource(R.mipmap.att);
        }else if(vv.contains("apple")) {
            imageView.setImageResource(R.mipmap.apple);
        }else if(vv.contains("sony")) {
            imageView.setImageResource(R.mipmap.sony);
        }else if(vv.contains("oracle")) {
            imageView.setImageResource(R.mipmap.oracle);
        }else{
            imageView.setImageResource(R.mipmap.go1);
        }

        return rowView;
    }
}
