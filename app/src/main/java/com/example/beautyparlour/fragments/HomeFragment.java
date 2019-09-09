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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.beautyparlour.R;
import com.example.beautyparlour.adapters.ServicesAdapter;
import com.example.beautyparlour.models.Service;

import org.json.JSONArray;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ServicesAdapter adapter;
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ServicesAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        getData();
        return v;
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "https://naseemali925.000webhostapp.com/cats.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("RESPONSE", response);
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray arr = new JSONArray(response);
                            for (int i = 0; i < arr.length(); ++i) {
                                String type = arr.getJSONObject(i).getString("type");
                                list.add(new Service(type));
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

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }



//    private void getData(){
//        try {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://naseemali925.000webhostapp.com/cats.php")
//                .get()
//                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36")
//                .addHeader("Accept", "*/*")
//                .addHeader("Cache-Control", "no-cache")
//                .addHeader("Postman-Token", "d1dde174-5e6b-4fec-b19b-b9e531c5dc4b,e6f7fdfa-0834-4345-a18c-a01820e08f5d")
//                .addHeader("Host", "naseemali925.000webhostapp.com")
//                .addHeader("Accept-Encoding", "gzip, deflate")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("cache-control", "no-cache")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//            System.out.println("RESPONSE = "+response.body().string());
//            JSONArray arr = new JSONArray(response.body().string());
//            for (int i = 0; i < arr.length(); ++i) {
//                String type = arr.getJSONObject(i).getString("type");
//                list.add(new Service(type));
//            }
//            adapter.notifyDataSetChanged();
//        } catch (Exception e) {
////            Log.d("ERROR_E",e.getMessage());
////            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }
//    }

}
