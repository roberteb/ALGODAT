package com.example.robert.algodat.exam;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robert.algodat.R;

public class ExamActivity extends AppCompatActivity {

    ImageView firstArrow;
    ImageView secondArrow;
    ImageView thirdArrow;
    ImageView forthArrow;
    ImageView fifthArrow;
    TextView timerTextView;
    long remainedSeconds = 0;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Exam");

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

        nextButton = (Button) findViewById(R.id.nextButton);

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        new CountDownTimer(5400000, 1000) {
            private long seconds = 60;

            public void onTick(long millisUntilFinished) {
                if(seconds==0){
                    seconds = 60;
                }
                timerTextView.setText(millisUntilFinished / 1000/60/60+":"+millisUntilFinished / 1000/60%60+":"+seconds--);
                remainedSeconds = millisUntilFinished;
            }

            public void onFinish() {
                timerTextView.setText("done!");
            }
        }.start();

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ExamActivity.this, ExamSelectionSort.class);
                mainIntent.putExtra("REMAINED_SECONDS", remainedSeconds);
                startActivity(mainIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //Up button
        super.onBackPressed();

        return true;
    }
}
