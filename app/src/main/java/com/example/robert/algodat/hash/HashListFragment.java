package com.example.robert.algodat.hash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.robert.algodat.R;

public class HashListFragment extends Fragment {

    Fragment frag;
    final static int hashIcons[]=
            { R.mipmap.ic_sort, R.mipmap.ic_sort, R.mipmap.ic_sort,
                    R.mipmap.ic_sort, R.mipmap.ic_sort, R.mipmap.ic_sort,
                    R.mipmap.ic_sort, R.mipmap.ic_sort, R.mipmap.ic_sort
            };
    final String[] hashText = {
            "BISEH Hashing", "Double Hashing", "Extendible Hashing", "Linear Hashing", "Separate Chaining"
    };

    public HashListFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hash_list_fragment, container, false);

        getActivity().setTitle("Hash Tables");

        ListView hashListView = (ListView)rootView.findViewById(R.id.hashListView);

        hashListView.setAdapter(new com.example.robert.algodat.sort
                .CustomAdapter(getActivity(), hashText, hashIcons, hashIcons.length));



        hashListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            case 0:
//                                getFragmentManager().beginTransaction()
//                                        .replace(R.id.hash_content, frag = new SortSelectionInfoFragment())
//                                        .addToBackStack(null).commit();
                                break;
                            case 1:
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
