package com.example.robert.algodat.sort;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.robert.algodat.R;


public class SortListFragment extends Fragment {


    Fragment frag;

    public SortListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sort_list_fragment, container, false);

        final String[] sortText = { "Selection Sort", "Quick Sort", "Merge Sort",
                                    "Counting Sort", "Bucket Sort", "Radix Sort",
                                    "Nasin Sort", "Fabian Sort", "Christian Sort"};

        //sortIcons for ListView
        int sortIcons[] = { R.mipmap.ic_hash, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
        };


        //assign ListView
        ListView sortListView = (ListView)rootView.findViewById(R.id.sortListView);


        sortListView.setAdapter(new com.example.robert.algodat.sort
                .CustomAdapter(getActivity(), sortText, sortIcons));

        sortListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            case 0:
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.sort_content, frag = new SortQuickInfoFragment())
                                        .addToBackStack(null).commit();
                                break;
                            case 1:
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.sort_content, frag = new SortQuickInfoFragment())
                                        .addToBackStack(null).commit();
                                break;
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                        }
                    }
                }
        );

        return rootView;
    }


}
