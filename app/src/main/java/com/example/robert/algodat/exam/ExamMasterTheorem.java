package com.example.robert.algodat.exam;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robert.algodat.R;

public class ExamMasterTheorem extends AppCompatActivity {

    ImageView firstArrow;
    ImageView secondArrow;
    ImageView thirdArrow;
    ImageView forthArrow;
    ImageView fifthArrow;
    TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_master_theorem);

        firstArrow = (ImageView) findViewById(R.id.firstExamArrow);
        firstArrow.setImageResource(R.drawable.arrow_seen);

        secondArrow = (ImageView) findViewById(R.id.secondExamArrow);
        secondArrow.setImageResource(R.drawable.arrow_unseen);

        thirdArrow = (ImageView) findViewById(R.id.thirdExamArrow);
        thirdArrow.setImageResource(R.drawable.arrow_unseen);

        forthArrow = (ImageView) findViewById(R.id.forthExamArrow);
        forthArrow.setImageResource(R.drawable.arrow_unseen);

        fifthArrow = (ImageView) findViewById(R.id.fifthExamArrow);
        fifthArrow.setImageResource(R.drawable.arrow_unseen);

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTextView.setText("s " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextView.setText("done!");
            }
        }.start();


    }
}
