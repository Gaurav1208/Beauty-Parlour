package com.example.beautyparlour;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    View view;
    private CardView Haircut,Skintreatment,Makeup,Handsandfeet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home,null);
        Haircut = (CardView) view.findViewById(R.id.haircut);
        Skintreatment = view.findViewById(R.id.sknt);
        Makeup = view.findViewById(R.id.mkup);
        Handsandfeet = view.findViewById(R.id.hanf);
        Haircut.setOnClickListener(this);
        Skintreatment.setOnClickListener(this);
        Makeup.setOnClickListener(this);
        Handsandfeet.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.haircut : i = new Intent(getContext(),HairType.class);startActivity(i);
            break;
            case R.id.sknt : i = new Intent(getContext(),Skinbasics.class);startActivity(i);
            break;
            case R.id.mkup : i = new Intent(getContext(),Makeuptypes.class);startActivity(i);
            break;
            case R.id.hanf : i = new Intent(getContext(),Handandfeettype.class);startActivity(i);
            break;
            default:break;
        }
    }
}