package com.example.robert.algodat.Sort;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.robert.algodat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSortList extends Fragment {


    public FragmentSortList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort_list, container, false);
    }

}
