package com.istu_rider;

import android.content.Intent;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeScreen extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    NavigationView view;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        view = (NavigationView) findViewById(R.id.navigation_view);


        if (toolbar != null) {
            toolbar.setTitle("Riders");
            setSupportActionBar(toolbar);
        }
        initDrawer();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    private void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };


        drawerLayout.setDrawerListener(drawerToggle);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) {
                } else {
                    setDrawerClick(menuItem.getItemId());
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    private void setDrawerClick(int itemId) {


        switch (itemId) {

            case R.id.drawer_chat:

                Intent iChat = new Intent(HomeScreen.this, ChatActivity.class);
                startActivity(iChat);
                break;

            case R.id.drawer_dashboard:

                Intent iDashBoard = new Intent(HomeScreen.this, DashBoardScreen.class);
                startActivity(iDashBoard);

                break;

            case R.id.drawer_home:

                break;

            case R.id.drawer_profile:
                Intent iProfile = new Intent(HomeScreen.this, ProfileScreen.class);
                startActivity(iProfile);
                break;

            case R.id.drawer_rating:
                Intent iRate = new Intent(HomeScreen.this, RateScreen.class);
                startActivity(iRate);
                break;

            case R.id.drawer_withdraw:
                Intent iWithdraw = new Intent(HomeScreen.this, WithDrawScreen.class);
                startActivity(iWithdraw);
                break;

            case R.id.drawer_topup:
                Intent iTopup = new Intent(HomeScreen.this, TopUpScreen.class);
                startActivity(iTopup);
                break;


        }
    }
}
