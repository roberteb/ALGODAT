package com.example.robert.algodat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPractice extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public FragmentPractice() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentPractice newInstance(int sectionNumber) {
        FragmentPractice fragment = new FragmentPractice();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_practice, container, false);
        TextView hashtablesTextView = (TextView) rootView.findViewById(R.id.hashtablesTextView);
        hashtablesTextView.setText("hashtables");
        return rootView;
    }
}