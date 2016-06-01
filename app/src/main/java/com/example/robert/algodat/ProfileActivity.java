package com.example.robert.algodat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.robert.algodat.R;
import com.example.robert.algodat.main_menu.BaseActivity;

public class ProfileActivity extends BaseActivity {

    private ContentLoadingProgressBar progressbarExams;
    private ContentLoadingProgressBar progressbarPractice;

    //Gakgqlk Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressbarExams = (ContentLoadingProgressBar) findViewById(R.id.progressExams);
        progressbarPractice = (ContentLoadingProgressBar) findViewById(R.id.progressPractice);
        progressbarExams.show();
        progressbarPractice.show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

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
     @Override
     protected void onPostCreate(Bundle savedInstanceState) {
         super.onPostCreate(savedInstanceState);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }

}
