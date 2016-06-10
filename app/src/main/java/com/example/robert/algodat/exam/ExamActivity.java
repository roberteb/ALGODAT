package com.example.robert.algodat.exam;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.robert.algodat.R;
import com.example.robert.algodat.sort.SortSelectionFragment;


public class ExamActivity extends AppCompatActivity {

    SortSelectionFragment sortSelectionFragment;
    FragmentTransaction ft;
    Button examNextButton;
    ViewSwitcher examViewSwitcher;
    ImageView firstArrowImageView;
    ImageView secondArrowImageView;
    ImageView thirdArrowImageView;
    ImageView fourthArrowImageView;
    ImageView fifthArrowImageView;
    TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        examNextButton = (Button) findViewById(R.id.examNextButton);
        examViewSwitcher = (ViewSwitcher) findViewById(R.id.examViewSwitcher);
        firstArrowImageView = (ImageView) findViewById(R.id.firstArrowImageView);
        secondArrowImageView = (ImageView) findViewById(R.id.secondArrowImageView);
        thirdArrowImageView = (ImageView) findViewById(R.id.thirdArrowImageView);
        fourthArrowImageView = (ImageView) findViewById(R.id.fourthArrowImageView);
        fifthArrowImageView = (ImageView) findViewById(R.id.fifthArrowImageView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

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
                secondArrowImageView.setImageResource(R.drawable.arrow_seen);
            }
        });
//        hash

        new CountDownTimer(5400000, 1000) {
            private long seconds = 60;

            public void onTick(long millisUntilFinished) {
                if(seconds==0){
                    seconds = 60;
                }
                timerTextView.setText(millisUntilFinished / 1000/60/60+":"+millisUntilFinished / 1000/60%60+":"+seconds--);
//                remainedSeconds = millisUntilFinished;
            }

            public void onFinish() {
                timerTextView.setText("done!");
            }
        }.start();


    }

}
