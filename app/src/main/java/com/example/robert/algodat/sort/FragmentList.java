package com.example.robert.algodat.sort;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.robert.algodat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";

    public FragmentList() {
        // Required empty public constructor
    }

    public static FragmentList newInstance(int sectionNumber) {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sort_fragment_list, container, false);

        final String[] textPractice = { "Selection Sort", "Quick Sort", "Merge Sort", "Counting Sort"};

        //flags for ListView (order dependent on locationOrder)
        int iconsPractice[] = { R.mipmap.ic_hash, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher
        };


        //assign ListView
        ListView itemListView = (ListView)rootView.findViewById(R.id.practiceListView);


        itemListView.setAdapter(new CustomAdapter(getActivity(), textPractice, iconsPractice));


        itemListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent;
                        switch (position){
                            case 0:
                                //intent = new Intent(getActivity(), ThisIsWrong.class);
                                //startActivity(intent);
                                break;
                            case 1:
                                //intent = new Intent(getActivity(), QuickSort.class);
                                //startActivity(intent);
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
