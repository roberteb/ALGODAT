package com.example.robert.algodat.exam;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.example.robert.algodat.R;
import com.example.robert.algodat.sort.SortListFragment;
import com.example.robert.algodat.sort.SortSelectionFragment;


public class ExamActivity extends AppCompatActivity {

    private static final int[] arrowIds ={ R.id.firstArrowImageView, R.id.secondArrowImageView,
            R.id.thirdArrowImageView, R.id.fourthArrowImageView, R.id.fifthArrowImageView };

    private ImageView[] arrowsImageView = new ImageView[arrowIds.length];
    private SortSelectionExamFragment sortSelectionExamFragment;
    private SortListFragment sortListFragment;
    private FragmentTransaction ft;
    private Button examNextButton;
    private Button examBackButton;
    private ViewFlipper examViewFlipper;
    private TextView timerTextView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        examNextButton = (Button) findViewById(R.id.examNextButton);
        examBackButton = (Button) findViewById(R.id.examBackButton);
        examViewFlipper = (ViewFlipper) findViewById(R.id.examViewFlipper);

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sortSelectionExamFragment = new SortSelectionExamFragment();
        sortListFragment = new SortListFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.exam_view1, sortSelectionExamFragment);
        ft.add(R.id.exam_view3, sortListFragment);
        ft.commit();

        counter = 0;
        examNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 4) {
                    examViewFlipper.showNext();
                    counter++;
                    arrowsImageView[counter] = (ImageView) findViewById(arrowIds[counter]);
                    arrowsImageView[counter].setImageResource(R.drawable.arrow_seen);
                }
            }
        });
//        hash

        examBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0){
                    examViewFlipper.showPrevious();
                    arrowsImageView[counter] = (ImageView)findViewById(arrowIds[counter]);
                    arrowsImageView[counter].setImageResource(R.drawable.arrow_unseen);
                    counter--;
                }
            }
        });

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
        onBackPressed();

        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        ExamActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
