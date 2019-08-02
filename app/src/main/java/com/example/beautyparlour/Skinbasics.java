package com.example.beautyparlour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Skinbasics extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ModelSkin> skinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skinbasics);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.scrollskin);

        skinList = new ArrayList<>();

        skinList.add(new ModelSkin(R.drawable.skincaresss,"Skin-Treatments","Different treatments for skin","view"));
        skinList.add(new ModelSkin(R.drawable.bodycaresss,"Skin-Care","Different forms of skin-care","view"));
        skinList.add(new ModelSkin(R.drawable.skincleansersss,"Skin-Cleanser","Different forms of skin-cleanser","view"));
        skinList.add(new ModelSkin(R.drawable.threadingsss,"Skin-Basics","Basic forms of Skin","view"));
        skinList.add(new ModelSkin(R.drawable.waxingsss,"Skin-Depletion","Different forms f depletion","view"));

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = LayoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);
        SkinAdapter adapter = new SkinAdapter(this,skinList);
        recyclerView.setAdapter(adapter);
    }
}
