package com.example.robert.algodat.exam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

import com.example.robert.algodat.R;
import com.example.robert.algodat.sort.SortSelectionFragment;


public class ExamActivity extends AppCompatActivity {

    SortSelectionFragment sortSelectionFragment;
    FragmentTransaction ft;
    Button examNextButton;
    ViewSwitcher examViewSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        examNextButton = (Button) findViewById(R.id.examNextButton);
        examViewSwitcher = (ViewSwitcher) findViewById(R.id.examViewSwitcher);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sortSelectionFragment = new SortSelectionFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.exam_view1, sortSelectionFragment);
        ft.commit();

        examNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examViewSwitcher.showNext();
            }
        });
//        hash



    }

}
