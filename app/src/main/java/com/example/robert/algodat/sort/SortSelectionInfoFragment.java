package com.example.robert.algodat.sort;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.robert.algodat.R;

public class SortSelectionInfoFragment extends Fragment {

    ViewSwitcher viewSwitcher;
    Button videoButton;
    Button infoButton;
    Button discussionButton;
    Button sortGoButton;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SortSelectionInfoFragment() {
        // Required empty public constructor
    }

    public static SortSelectionInfoFragment newInstance(int sectionNumber) {
        SortSelectionInfoFragment fragment = new SortSelectionInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sort_selection_info_fragment, container, false);

        getActivity().setTitle("Selection Sort");
        viewSwitcher = (ViewSwitcher)rootView.findViewById(R.id.viewSwitcher);
        infoButton = (Button)rootView.findViewById(R.id.infoButton);
        videoButton = (Button)rootView.findViewById(R.id.videoButton);
        sortGoButton = (Button)rootView.findViewById(R.id.sortGoButton);

        infoButton.setBackgroundColor(Color.parseColor("#aa66cc"));
        videoButton.setBackgroundColor(Color.parseColor("#aa66cc"));
        infoButton.setPadding(0,70,0,70);
        videoButton.setPadding(0,70,0,70);

        TextView sortTypeTextView = (TextView)rootView.findViewById(R.id.typeTextView);
        TextView sortInfoTextView = (TextView)rootView.findViewById(R.id.sortInfoTextView);

        sortTypeTextView.setText("Selection Sort:");
        sortInfoTextView.setText("Placehoder, placeholder ,placeholder\n" +
                "Placehoder, placeholder ,placeholder\n" +
                "Placehoder, placeholder ,placeholder\n" +
                "Placehoder, placeholder ,placeholder\n");

        infoButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {
                        new AnimationUtils();
                        viewSwitcher.setAnimation(AnimationUtils.makeInChildBottomAnimation(getContext()));
                        viewSwitcher.showNext();
                    }
                }
        );

        videoButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {
                        new AnimationUtils();
                        viewSwitcher.setAnimation(AnimationUtils.makeInChildBottomAnimation(getContext()));
                        viewSwitcher.showPrevious();
                    }
                }
        );

        sortGoButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(getActivity(), SortSelectionActivity.class);
                        startActivity(intent);
                    }
                }
        );

        discussionButton = (Button)rootView.findViewById(R.id.discussionButton);
        discussionButton.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.ic_hash, 0, 0);
        discussionButton.setPadding(0, 30, 0, 0);

        return rootView;
    }


}
