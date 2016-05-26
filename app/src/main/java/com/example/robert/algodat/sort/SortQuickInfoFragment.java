package com.example.robert.algodat.sort;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.robert.algodat.R;

public class SortQuickInfoFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SortQuickInfoFragment() {
        // Required empty public constructor
    }

    public static SortQuickInfoFragment newInstance(int sectionNumber) {
        SortQuickInfoFragment fragment = new SortQuickInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sort_quick_info_fragment, container, false);

        return rootView;
    }

}
