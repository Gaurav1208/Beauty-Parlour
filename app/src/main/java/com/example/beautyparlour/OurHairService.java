package com.example.beautyparlour;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class OurHairService extends AppCompatActivity {

    CardView fringes;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_hair_service);
        b1 = findViewById(R.id.fringeadd);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OurHairService.this,"Added to cart",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
