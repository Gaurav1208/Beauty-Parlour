package com.example.beautyparlour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Makeuptypes extends AppCompatActivity {

    RecyclerView recyclerView;;

    ArrayList<ModelMakeup> makeupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeuptypes);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.scrollmakeup);

        makeupList = new ArrayList<>();
        makeupList.add(new ModelMakeup(R.drawable.hairformss,"Hair-Forms","Different forms of hair","view"));
        makeupList.add(new ModelMakeup(R.drawable.haircaress,"Hair-Care","Different forms of hair-care","view"));
        makeupList.add(new ModelMakeup(R.drawable.haircolors,"Hair-Colour","Different forms of hair-colour","view"));
        makeupList.add(new ModelMakeup(R.drawable.hairstylingss,"Hair-Styling","Different forms of hair-styles","view"));
        makeupList.add(new ModelMakeup(R.drawable.haircaresss,"Hair-Cuts","Different forms of hair-cuts","view"));

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = LayoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);
        MakeupAdapter adapter = new MakeupAdapter(this,makeupList);
        recyclerView.setAdapter(adapter);
    }
}
