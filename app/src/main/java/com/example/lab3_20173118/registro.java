package com.example.lab3_20173118;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;


public class registro extends AppCompatActivity {

    EditText txtNombre;
    EditText txtGenero;
    EditText txtDueno;
    EditText txtDNI;
    EditText txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void RegresarAlMain(View view){

        SharedPreferences sharpref = getSharedPreferences("datos_mascotas", Context.MODE_PRIVATE);

        EditText txtNombre = findViewById(R.id.txtNombre);
        EditText txtGenero = findViewById(R.id.txtGenero);
        EditText txtDueno = findViewById(R.id.txtDueno);
        EditText txtDNI = findViewById(R.id.txtDNI);
        EditText txtDescripcion = findViewById(R.id.txtDescripcion);

        SharedPreferences.Editor editor = sharpref.edit();
        editor.putString("nombre",txtNombre.getText().toString());
        editor.putString("genero",txtGenero.getText().toString());
        editor.putString("dueno",txtDueno.getText().toString());
        editor.putString("DNI",txtDNI.getText().toString());
        editor.putString("descripcion",txtDescripcion.getText().toString());
        editor.commit();

        Intent RegresarAlMain = new Intent(this, MainActivity.class);
        startActivity(RegresarAlMain);
    }


}