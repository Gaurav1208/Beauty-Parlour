package com.example.beautyparlour.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.beautyparlour.R;
import com.example.beautyparlour.activities.Services;
import com.example.beautyparlour.models.Service;
import com.example.beautyparlour.utils.Constants;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Service> list;

    public CatAdapter(Context context, ArrayList<Service> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.service, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder holder, int position) {
        final Service service = list.get(position);
        holder.name.setText(service.getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(8));
        Glide
                .with(mContext)
                .load("https://httpsgauravhuria08wixsitecomvaigau1208.000webhostapp.com/img/" + service.getThumbnail())
//                .centerCrop()
                .apply(requestOptions)
//                .placeholder(R.drawable.loading_spinner)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Services.class);
                intent.putExtra(Constants.CAT, service.getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}


