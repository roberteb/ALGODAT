package com.example.robert.algodat;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter <String> {
    private int[] flags;

    //constructor
    public CustomAdapter(Context context, String[] locations, int[] flags) {
        super(context, R.layout.custom_block, locations);
        this.flags = flags;
    }



    //set the customView for the listItems
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_block, parent, false);

        //assign textView and imageView
        TextView listItemTextView = (TextView) customView.findViewById(R.id.textView);
        ImageView listItemImageView = (ImageView) customView.findViewById(R.id.imageView);

        //assign particular flags and locations to the listItems
        listItemTextView.setText(getItem(position));
        listItemImageView.setImageResource(flags[position]);

        //return customView to locationAdapter in Main.class
        return customView;
    }
}
