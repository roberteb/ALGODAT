package com.example.robert.algodat.sort;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robert.algodat.R;

public class CustomAdapter extends ArrayAdapter <String> {
    private int[] icons;
    private String[] text;
    private static int[] count;

    //constructor
    public CustomAdapter(Context context, String[] text, int[] icons, int length) {
        super(context, R.layout.custom_list_item, text);
        this.icons = icons;
        this.text = text;
        count = new int[length];
    }

    //set the customView for the listItems
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_list_item, parent, false);

        TextView typeTextView = (TextView) customView.findViewById(R.id.typeTextView);
        TextView visitedTextView = (TextView) customView.findViewById(R.id.visitedTextView);
        ImageView typeImageView = (ImageView) customView.findViewById(R.id.typeImageView);

        typeTextView.setText(text[position]);
        visitedTextView.setText(count[position] + " times");
        typeImageView.setImageResource(icons[position]);

        return customView;
    }
}
