package com.example.beautyparlour.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.beautyparlour.R;
import com.example.beautyparlour.welcome;

public class Profile extends Fragment {
    public Profile() {
        // Required empty public constructor
    }

    public static Profile instance() {
        Profile fragment = new Profile();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        v.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((welcome) getActivity()).logOut();
            }
        });
        return v;
    }

}
