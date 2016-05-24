package com.example.robert.algodat.MainMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.robert.algodat.R;

public class FragmentExam extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public FragmentExam() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentExam newInstance(int sectionNumber) {
        FragmentExam fragment = new FragmentExam();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exam, container, false);

        return rootView;
    }
}