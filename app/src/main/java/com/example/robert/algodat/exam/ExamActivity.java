package com.example.robert.algodat.exam;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.robert.algodat.R;
import com.example.robert.algodat.sort.SortSelectionFragment;


public class ExamActivity extends AppCompatActivity {

    private static final int[] arrowIds ={ R.id.firstArrowImageView, R.id.secondArrowImageView,
            R.id.thirdArrowImageView, R.id.fourthArrowImageView, R.id.fifthArrowImageView };

    private ImageView[] arrowsImageView = new ImageView[arrowIds.length];
    private SortSelectionFragment sortSelectionFragment;
    private FragmentTransaction ft;
    private Button examNextButton;
    private Button examBackButton;
    private ViewSwitcher examViewSwitcher;
    private TextView timerTextView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        examNextButton = (Button) findViewById(R.id.examNextButton);
        examBackButton = (Button) findViewById(R.id.examBackButton);
        examViewSwitcher = (ViewSwitcher) findViewById(R.id.examViewSwitcher);

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sortSelectionFragment = new SortSelectionFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.exam_view1, sortSelectionFragment);
        ft.commit();

        counter = 0;
        examNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 4) {
                    examViewSwitcher.showNext();
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
                    examViewSwitcher.showPrevious();
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
}
