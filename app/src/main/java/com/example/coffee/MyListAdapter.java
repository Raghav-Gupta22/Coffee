package com.example.coffee;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    Integer allimages[];
    String alltitle[];

    public MyListAdapter(Activity context, Integer[] allimages, String[] alltitle) {
        super(context,R.layout.list_row,alltitle);
        this.context = context;
        this.allimages = allimages;
        this.alltitle = alltitle;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview=inflater.inflate(R.layout.list_row,null,true);
        ImageView imageView=(ImageView)rowview.findViewById(R.id.image);
        TextView text=(TextView)rowview.findViewById(R.id.text);
        text.setText(alltitle[position]);
        imageView.setImageResource(allimages[position]);

        return rowview;
    }
}
