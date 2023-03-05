package com.example.meetnsports;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import 	androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.darkCyan));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment frag = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, frag);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();
        Fragment fragment = null;

        switch(id){
            case R.id.nav_football:
                fragment = new SoccerFragment();
                break;
            case R.id.nav_americanfootball:
                fragment = new FootballFragment();
                break;
            case R.id.nav_basketball:
                fragment = new BasketballFragment();
                break;
            case R.id.nav_cricket:
                fragment = new CricketFragment();
                break;
            case R.id.nav_cycling:
                fragment = new CyclingFragment();
                break;
            case R.id.nav_esports:
                fragment = new EsportsFragment();
                break;
            case R.id.nav_fighting:
                fragment = new FightingFragment();
                break;
            case R.id.nav_golf:
                fragment = new GolfFragment();
                break;
            case R.id.nav_fitness:
                fragment = new FitnessFragment();
                break;
            case R.id.nav_gymnastics:
                fragment = new GymnasticsFragment();
                break;
            case R.id.nav_handball:
                fragment = new HandballFragment();
                break;
            case R.id.nav_rugby:
                fragment = new RugbyFragment();
                break;
            case R.id.nav_hockey:
                fragment = new HockeyFragment();
                break;
            case R.id.nav_running:
                fragment = new RacingFragment();
                break;
            case R.id.nav_tennis:
                fragment = new TennisFragment();
                break;
            case R.id.nav_volleyball:
                fragment = new VolleyballFragment();
                break;
            default:
                fragment = new HomeFragment();

        }

        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
