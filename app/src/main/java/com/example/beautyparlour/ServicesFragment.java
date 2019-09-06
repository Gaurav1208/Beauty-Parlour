package com.example.beautyparlour;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class ServicesFragment extends Fragment {

    ConstraintLayout expandableView;
    Button arrowBtn;
    CardView cardview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_services,container, false);
        expandableView = v.findViewById(R.id.expandableView);
        arrowBtn = v.findViewById(R.id.arrowBtn);
        cardview = v.findViewById(R.id.cardview);
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

        return v;
    }

    public void doIt(){
        TransitionManager.beginDelayedTransition(cardview,new AutoTransition());
        expandableView.setVisibility(View.VISIBLE);
        arrowBtn.setBackgroundResource(R.drawable.ic_arrow_drop_up_black);
    }

}