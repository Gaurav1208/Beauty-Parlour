package com.example.beautyparlour.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.beautyparlour.R;
import com.example.beautyparlour.adapters.CatAdapter;
import com.example.beautyparlour.models.Service;
import com.example.beautyparlour.utils.Utils;

import org.json.JSONArray;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private CatAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Service> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment instance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CatAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        getData();
        return v;
    }

    private void getData() {
        String url = "https://httpsgauravhuria08wixsitecomvaigau1208.000webhostapp.com/cats.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RESPONSE", response);
//                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray arr = new JSONArray(response);
                            for (int i = 0; i < arr.length(); ++i) {
                                String type = arr.getJSONObject(i).getString("type");
                                String thumbnail = arr.getJSONObject(i).getString("thumbnail");
                                list.add(new Service(type, thumbnail));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Utils.getInstance().addRequest(stringRequest);
    }

}
