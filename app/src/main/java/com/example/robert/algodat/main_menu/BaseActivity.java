package com.example.robert.algodat.main_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.robert.algodat.ProfileActivity;
import com.example.robert.algodat.R;
import com.example.robert.algodat.SettingsActivity;
import com.example.robert.algodat.sort.SortActivity;

import java.util.Map;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    protected void onCreateDrawer() {
        // R.id.drawer_layout should be in every activity with exactly the same id.
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerToggle = new ActionBarDrawerToggle((AppCompatActivity) this, drawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close) {
            public void onDrawerClosed(View view) {
               super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
               super.onDrawerClosed(drawerView);
            }
        };
        //drawerLayout.setDrawerListener(drawerToggle);
        //drawerLayout.setDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.design_navigation_view);
        LayoutInflater.from(this).inflate(R.layout.navigation_drawer_header, navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        final Context context = this;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        super.setContentView(layoutResID);
        onCreateDrawer();
    }
   /* private void goToNavDrawerItem(int item) {
        Intent intent;
        switch (item) {
            case R.id.home_id: {
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.profile_id: {
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.settings_id: {
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }*/

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_id: {
                Intent intent = new Intent(this, MainActivity.class);
                if(getClass()==MainActivity.class){
                    drawerLayout.closeDrawers();
                    break;
                }
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.profile_id: {
                Intent intent = new Intent(this, ProfileActivity.class);
                if(getClass()==ProfileActivity.class){
                    drawerLayout.closeDrawers();
                    break;
                }
                drawerLayout.closeDrawers();
                startActivity(intent);
                break;
            }
            case R.id.feedback_id: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.settings_id: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.invite_friends_id: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            }
        }
        return true;
    }
}