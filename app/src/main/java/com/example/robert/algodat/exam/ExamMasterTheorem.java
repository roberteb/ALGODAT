package com.example.robert.algodat.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.robert.algodat.R;

public class ExamMasterTheorem extends AppCompatActivity {

    ImageView firstArrow;
    ImageView secondArrow;
    ImageView thirdArrow;
    ImageView forthArrow;
    ImageView fifthArrow;
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

    }
}
