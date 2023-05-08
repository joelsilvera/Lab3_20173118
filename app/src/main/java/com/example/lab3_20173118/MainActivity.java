package com.example.lab3_20173118;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<List<Integer>> listaDeListas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeListas = new ArrayList<>();
    }

    public void IrARegistro(View view){
        Intent IrARegistro = new Intent(this, registro.class);
        startActivity(IrARegistro);
    }

    public void IrAEmergencia(View view){
        Intent IrAEmergencia = new Intent(this, emergencia.class);
        startActivity(IrAEmergencia);
    }

    public void IrAHistorial(View view){
        Intent IrAHistorial = new Intent(this, historial.class);
        startActivity(IrAHistorial);
    }
}