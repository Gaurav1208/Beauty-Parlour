package com.example.beautyparlour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class welcome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav_menu);
        navigation.setOnNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frames, com.example.beautyparlour.fragments.HomeFragment.instance()).commit();
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frames,fragment).commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        if (id == R.id.homes) {
            fm.beginTransaction().replace(R.id.frames, new HomeFragment()).commit();
        } else if (id == R.id.service) {
            fm.beginTransaction().replace(R.id.frames, new ServicesFragment()).commit();
        } else if (id == R.id.book) {
            fm.beginTransaction().replace(R.id.frames, new BooknowFragment()).commit();
        } else if (id == R.id.offer) {
            fm.beginTransaction().replace(R.id.frames, new OffersFragment()).commit();
        } else if (id == R.id.abtus) {
            fm.beginTransaction().replace(R.id.frames, new AboutusFragment()).commit();
        }
        return true;

    }



}
