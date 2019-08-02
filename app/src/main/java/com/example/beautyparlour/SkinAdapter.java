package com.example.beautyparlour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SkinAdapter extends RecyclerView.Adapter<SkinAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelSkin> mList;
    SkinAdapter(Context context, ArrayList<ModelSkin> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public SkinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.sh_skin_services,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull SkinAdapter.ViewHolder holder, int position) {

        ModelSkin skinitem = mList.get(position);
        ImageView image = holder.item_image;
        TextView name,desc,view;

        name = holder.item_name;
        desc = holder.item_desc;
        view = holder.item_price;

        image.setImageResource(skinitem.getImage());

        name.setText(skinitem.getName());
        desc.setText(skinitem.getDesc());
        view.setText(skinitem.getView());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name,item_desc,item_price;

        public ViewHolder(View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_price = itemView.findViewById(R.id.view_item);
        }
    }
}
