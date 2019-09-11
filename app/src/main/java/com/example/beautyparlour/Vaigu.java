package com.example.beautyparlour;

import android.app.Application;

import com.example.beautyparlour.utils.Utils;

public class Vaigu extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.initialize(getApplicationContext());
    }
}
