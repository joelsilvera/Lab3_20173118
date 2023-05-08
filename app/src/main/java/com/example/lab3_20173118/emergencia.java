package com.example.lab3_20173118;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class emergencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
    }

    public void CalcularTiempo(View view){
        EditText distOrigen = findViewById(R.id.distOrigen);
        EditText distDestino = findViewById(R.id.distDestino);
        String origen = distOrigen.getText().toString();
        String destino = distDestino.getText().toString();
        String ruta = origen + "-" + destino;

        String tiempo=null;
        if(origen.equals("Lince") && destino.equals("Lince")){
           tiempo = "10";
        }
        if((origen.equals("San Isidro") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("San Isidro"))){
            tiempo = "15";
        }
        if((origen.equals("Magdalena") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("Magdalena"))){
            tiempo = "20";
        }
        if((origen.equals("Jesús María") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("Jesús María"))){
            tiempo = "25";
        }
        TextView txtminutos = findViewById(R.id.txtminutos);
        txtminutos.setText(tiempo + " minutos");


        SharedPreferences sharpref = getSharedPreferences("datos_mascotas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharpref.edit();
        editor.putString("ruta",ruta);
        editor.commit();

        List<String> lista1 = new ArrayList<>();
        lista1.add(sharpref.getString("nombre",""));
        lista1.add(sharpref.getString("genero",""));
        lista1.add(sharpref.getString("dueno",""));
        lista1.add(sharpref.getString("DNI",""));
        lista1.add(sharpref.getString("descripcion",""));
        lista1.add(sharpref.getString("ruta",""));

        List<List<String>> mascotasConSolicitud = ClaseGlobal.getmascotasConSolicitud();
        if (mascotasConSolicitud == null) {
            mascotasConSolicitud = new ArrayList<>();
            ClaseGlobal.setmascotasConSolicitud(mascotasConSolicitud);
        }

        ClaseGlobal.agregarMascota(lista1);
    }

    public void ParaMain(View view){
        Intent ParaMain = new Intent(this, MainActivity.class);
        startActivity(ParaMain);
    }
}