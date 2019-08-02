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

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelMakeup> mList;
    MakeupAdapter(Context context, ArrayList<ModelMakeup> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.sh_makeup_services,parent,false);
        ViewHolder viewHolder = new MakeupAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupAdapter.ViewHolder holder, int position) {
        ModelMakeup makeupitem = mList.get(position);
        ImageView image = holder.item_image;
        TextView name,desc,view;

        name = holder.item_name;
        desc = holder.item_desc;
        view = holder.item_price;

        image.setImageResource(makeupitem.getImage());

        name.setText(makeupitem.getName());
        desc.setText(makeupitem.getDesc());
        view.setText(makeupitem.getView());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name,item_desc,item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_price = itemView.findViewById(R.id.view_item);
        }
    }
}
