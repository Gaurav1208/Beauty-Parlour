package com.example.beautyparlour;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.beautyparlour.fragments.HomeFragment;
import com.example.beautyparlour.fragments.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class welcome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav_menu);
        navigation.setOnNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frames, HomeFragment.instance()).commit();
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frames, fragment).commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        if (id == R.id.homes) {
            fm.beginTransaction().replace(R.id.frames, HomeFragment.instance()).commit();
        } else if (id == R.id.service) {
            fm.beginTransaction().replace(R.id.frames, new ServicesFragment()).commit();
        } else if (id == R.id.book) {
            fm.beginTransaction().replace(R.id.frames, new BooknowFragment()).commit();
        } else if (id == R.id.offer) {
            fm.beginTransaction().replace(R.id.frames, new OffersFragment()).commit();
        } else if (id == R.id.abtus) {
            fm.beginTransaction().replace(R.id.frames, Profile.instance()).commit();
        }
        return true;

    }


}
