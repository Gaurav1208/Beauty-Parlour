package com.example.beautyparlour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HairType extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ModelHair> hairList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_type);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.scrollhair);

        hairList = new ArrayList<>();

        hairList.add(new ModelHair(R.drawable.hairformss,"Hair-Forms","Different forms of hair","view"));
        hairList.add(new ModelHair(R.drawable.haircaress,"Hair-Care","Different forms of hair-care","view"));
        hairList.add(new ModelHair(R.drawable.haircolors,"Hair-Colour","Different forms of hair-colour","view"));
        hairList.add(new ModelHair(R.drawable.hairstylingss,"Hair-Styling","Different forms of hair-styles","view"));
        hairList.add(new ModelHair(R.drawable.haircaresss,"Hair-Cuts","Different forms of hair-cuts","view"));

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = LayoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);
        HairAdapter adapter = new HairAdapter(this,hairList);
        recyclerView.setAdapter(adapter);
    }
}
