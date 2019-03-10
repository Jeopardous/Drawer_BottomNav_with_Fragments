package com.cheguza.facilitycenter;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mdrawlayout;
    private ActionBarDrawerToggle mtoggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdrawlayout=(DrawerLayout) findViewById(R.id.drawerLayout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mtoggle=new ActionBarDrawerToggle(this,mdrawlayout,R.string.open,R.string.close);
        mdrawlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container1,new HomeFrag()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment=null;

                switch (item.getItemId())
                {
                    case R.id.Home:
                        selectedFragment=new HomeFrag();

                        break;
                    case R.id.happenings:
                        selectedFragment=new NewComerFrag();
                        break;
                    case R.id.summary:
                        selectedFragment=new SummaryFrag();
                        break;
                    case R.id.wallet:
                        selectedFragment=new WalletFrag();
                        break;
                    case R.id.help:
                        selectedFragment=new HelpFrag();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container1,selectedFragment).commit();
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item))
        {
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
