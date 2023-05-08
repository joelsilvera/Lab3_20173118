package com.example.lab3_20173118;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.genView.setText(items.get(position).getGen());
        holder.personView.setText(items.get(position).getPerson());
        holder.dniView.setText(items.get(position).getDni());
        holder.descriptionView.setText(items.get(position).getDescription());
        holder.rutaView.setText(items.get(position).getRuta());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
