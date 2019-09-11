package com.example.beautyparlour;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.beautyparlour.fragments.HomeFragment;
import com.example.beautyparlour.fragments.Profile;
import com.example.beautyparlour.utils.Utils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class welcome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav_menu);
        navigation.setOnNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frames, HomeFragment.instance()).commit();
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestId()
                .requestProfile()
                .requestIdToken("1013393434218-ba6oh9huibc77pup1918lou5c8av4e72.apps.googleusercontent.com")
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                .build();

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


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void logOut() {
        Utils.getInstance().logout();
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...
                        if (status.isSuccess())
                            Toast.makeText(welcome.this, "Logged Out", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
