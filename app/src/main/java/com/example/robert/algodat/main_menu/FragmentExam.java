package com.example.robert.algodat.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.robert.algodat.R;
import com.example.robert.algodat.exam.ExamActivity;
import com.example.robert.algodat.exam.ExamMasterTheorem;

public class FragmentExam extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private ImageView examModeIcon;
    private Switch examModeSwitch;
    private TextView modeTextView;

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
        View rootView = inflater.inflate(R.layout.main_menu_fragment_exam, container, false);

        examModeIcon = (ImageView) rootView.findViewById(R.id.examModeIcon);
        examModeIcon.setImageResource(R.mipmap.ic_easy);
        modeTextView = (TextView) rootView.findViewById(R.id.modeTextView);

        examModeSwitch = (Switch) rootView.findViewById(R.id.examModeSwitch);
        examModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    examModeIcon.setImageResource(R.mipmap.ic_hard);
                    modeTextView.setText("HARD");
                } else {
                    examModeIcon.setImageResource(R.mipmap.ic_easy);
                    modeTextView.setText("EASY");
                }
            }
        });

        examModeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), ExamActivity.class);
                startActivity(mainIntent);
            }
        });

        return rootView;
    }
}