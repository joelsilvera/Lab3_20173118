package com.example.lab3_20173118;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.BaseProgressIndicator;

import java.util.ArrayList;
import java.util.List;

public class historial extends AppCompatActivity {

    TextView cuadroDeTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        List<List<String>> mascotasConSolicitud = ClaseGlobal.getmascotasConSolicitud();
        for (List<String> lista : mascotasConSolicitud) {
            items.add(new Item("Mascota: " + lista.get(0),"Genero: " + lista.get(1),0,"Dueño: " + lista.get(2),"DNI: " + lista.get(3),"Descripcion: " + lista.get(4),"Ruta: " + lista.get(5)));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
        /*
        cuadroDeTexto = (TextView) findViewById(R.id.cuadroDeTexto);
        List<List<String>> mascotasConSolicitud = ClaseGlobal.getmascotasConSolicitud();

        for (List<String> lista : mascotasConSolicitud) {
            cuadroDeTexto.append("Mascota: " + lista.get(0) + "\n");
            cuadroDeTexto.append("Genero: " + lista.get(1) + "\n");
            cuadroDeTexto.append("Dueño: " + lista.get(2) + "\n");
            cuadroDeTexto.append("DNI: " + lista.get(3) + "\n");
            cuadroDeTexto.append("Descripcion: " + lista.get(4) + "\n");
            cuadroDeTexto.append("Ruta: " + lista.get(5) + "\n");
            cuadroDeTexto.append("\n");
        }
        */
    }

}