package com.example.lab3_20173118;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView,genView, personView, dniView, descriptionView, rutaView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        genView = itemView.findViewById(R.id.gen);
        personView = itemView.findViewById(R.id.person);
        dniView = itemView.findViewById(R.id.dni);
        descriptionView = itemView.findViewById(R.id.description);
        rutaView = itemView.findViewById(R.id.ruta);

    }
}
