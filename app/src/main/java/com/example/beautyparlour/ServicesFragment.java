package com.example.beautyparlour;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.annotation.Target;

public class ServicesFragment extends AppCompatActivity {

    ConstraintLayout expandableView;
    Button arrowBtn;
    CardView cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_services);

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardview = findViewById(R.id.cardview);
        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableView.getVisibility()==View.GONE){
                    doIt();
                }else{
                    TransitionManager.beginDelayedTransition(cardview,new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_arrow_drop_down_black);
                }
            }
        });

    }

    @Target(value = )
    public void doIt(){
        TransitionManager.beginDelayedTransition(cardview,new AutoTransition());
        expandableView.setVisibility(View.VISIBLE);
        arrowBtn.setBackgroundResource(R.drawable.ic_arrow_drop_up_black);
    }

}