package com.view;

import android.os.Bundle;
import android.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.R;

import dashboard.FragmentDashboard;
import payment_reversal.FragmentPaymentReversal;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  DrawerLayout drawer;
    private  NavigationView navigationView;
    private  Toolbar toolbar;
    private  View header;
    private ImageView user;
    private static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new FragmentPaymentReversal()).commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        header = navigationView.getHeaderView(0);
        user = (ImageView) header.findViewById(R.id.imageView);
        if(user != null){
            Log.d("Header Listner","Header found");
            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toolbar.setTitle("Edit Profile");
                    fm.beginTransaction().replace(R.id.content_frame, new FragmentDashboard()).commit();
                    drawer.closeDrawer(GravityCompat.START);
                }
            });
        }else Log.d("Header Listner","Header NULL");

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            Log.d("Nav Drawer","FragmentDashboard");
            toolbar.setTitle("Dashboard");
            fm.beginTransaction().replace(R.id.content_frame, new FragmentDashboard()).commit();
        } else if (id == R.id.nav_collectMoney) {

        } else if (id == R.id.nav_transactionHistory) {

        } else if (id == R.id.nav_comissions) {

        } else if (id == R.id.nav_paymentReversal) {
            toolbar.setTitle("Payment Reversal");
            fm.beginTransaction().replace(R.id.content_frame, new FragmentPaymentReversal()).commit();
        } else if (id == R.id.nav_addUser) {

        }else if (id == R.id.nav_offers) {

        }else if (id == R.id.nav_help) {

        }else if (id == R.id.nav_rateApplication) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
