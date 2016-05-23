package com.example.robert.algodat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;


public class FragmentLearn extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public FragmentLearn() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FragmentLearn newInstance(int sectionNumber) {
            FragmentLearn fragment = new FragmentLearn();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_learn, container, false);

            String[] locations = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6"};

            //flags for ListView (order dependent on locationOrder)
            int flags[] = { R.mipmap.ic_hash, R.mipmap.ic_hash,
                            R.mipmap.ic_hash, R.mipmap.ic_launcher,
                            R.mipmap.ic_hash, R.mipmap.ic_hash
                            };


            //assign ListView
            GridView locationGridView = (GridView)rootView.findViewById(R.id.gridView);


            locationGridView.setAdapter(new CustomAdapter(getActivity(), locations, flags));


         /*   locationGridView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String location = String.valueOf(parent.getItemAtPosition(position));
                            Intent intent = new Intent(Main.this, Weather.class);
                            intent.putExtra("locationMessage", location);
                            startActivity(intent);
                        }
                    }

            );
            */

            return rootView;
        }
    }