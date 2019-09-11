package com.example.beautyparlour.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beautyparlour.R;
import com.example.beautyparlour.utils.Utils;
import com.example.beautyparlour.welcome;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Utils.getInstance().isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), welcome.class));
            finish();
        } else {
            setContentView(R.layout.activity_splash);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }, 2000);
        }
    }
}
