package com.example.robert.algodat.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.robert.algodat.R;
import com.example.robert.algodat.hash.HashActivity;
import com.example.robert.algodat.sort.SortActivity;


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
        View rootView = inflater.inflate(R.layout.main_menu_fragment_practice, container, false);

        final String[] textPractice = { "Hash Tables", "Sorting Algorithms", "Master Theorem", "Graphs"};

        //icons for GridView
        int iconsPractice[] = { R.mipmap.ic_practice01, R.mipmap.ic_practice02,
                                R.mipmap.ic_practice03, R.mipmap.ic_learn06
                                };


        //assign GridView
        GridView practiceGridView = (GridView)rootView.findViewById(R.id.practiceGridView);


        practiceGridView.setAdapter(new CustomAdapter(getActivity(), textPractice, iconsPractice));


         practiceGridView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent;
                    switch (position){
                        case 0:
                            intent = new Intent(getActivity(), HashActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(getActivity(), SortActivity.class);
                            startActivity(intent);
                            break;
                        case 2:
                        case 3:
                        default:
                    }


                }
            }
         );


        return rootView;
    }
}