package com.example.beautyparlour.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.beautyparlour.R;
import com.example.beautyparlour.adapters.ServicesAdapter;
import com.example.beautyparlour.models.Service;
import com.example.beautyparlour.utils.Constants;
import com.example.beautyparlour.utils.Utils;

import org.json.JSONArray;

import java.util.ArrayList;

public class Services extends AppCompatActivity {

    private ServicesAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Service> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ServicesAdapter(this, list);
        recyclerView.setAdapter(adapter);
        Intent intent = getIntent();
        if (intent != null) {
            String cat = intent.getStringExtra(Constants.CAT);
            if (cat != null) {
                getData(cat);
            } else {
                finish();
            }
        } else {
            finish();
        }
    }

    private void getData(String cat) {
        String url = "https://httpsgauravhuria08wixsitecomvaigau1208.000webhostapp.com/services.php?cat=" +
                cat.replace(" ", "%20");
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
                                String name = arr.getJSONObject(i).getString("name");
                                String thumbnail = arr.getJSONObject(i).getString("thumbnail");
                                Service service = new Service(name, thumbnail);
                                service.setType(type);
                                list.add(service);
                            }
                            adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            Toast.makeText(Services.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(Services.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Utils.getInstance().addRequest(stringRequest);
    }
}
