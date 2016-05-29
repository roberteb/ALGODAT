package com.example.robert.algodat.sort;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.robert.algodat.R;

public class CustomAdapter extends ArrayAdapter <String> {
    private int[] icons;
    private static int[] count;

    //constructor
    public CustomAdapter(Context context, String[] text, int[] icons, int length) {
        super(context, R.layout.custom_list_item, text);
        this.icons = icons;
        count = new int[length];
    }

    //set the customView for the listItems
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_list_item, parent, false);

        //assign textView and imageView
        TextView compoundTextView = (TextView) customView.findViewById(R.id.compoundTextView);

        //assign particular flags and locations to the listItems
        compoundTextView.setText(getItem(position));
        compoundTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(icons[position], 0, 0, 0);

        //return customView to locationAdapter in MainActivity.class
        return customView;
    }
}
