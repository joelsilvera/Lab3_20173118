package com.example.lab3_20173118;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class emergencia extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private static final long COUNTDOWN_INTERVAL = 1000; // Intervalo de 1 segundo
    private static final long COUNTDOWN_TIME = 10000; // Duración de la cuenta regresiva en milisegundos

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

        int tiempo=0;
        if(origen.equals("Lince") && destino.equals("Lince")){
           tiempo = 600000; //10 min
        }
        if((origen.equals("San Isidro") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("San Isidro"))){
            tiempo = 900000; //15 min
        }
        if((origen.equals("Magdalena") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("Magdalena"))){
            tiempo = 1200000; // 20 min
        }
        if((origen.equals("Jesús María") && destino.equals("Lince"))||(origen.equals("Lince") && destino.equals("Jesús María"))){
            tiempo = 1500000; // 25 min
        }

        //CREAMOS EN CRONOMETRO
        countdownText = findViewById(R.id.countdown_text);
        countDownTimer = new CountDownTimer(tiempo, COUNTDOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                int seconds = (int) (timeLeftInMillis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                countdownText.setText(timeFormatted);
            }
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountdownText();
            }
        };
        countDownTimer.start();

        //GUARDASMOS DATOS EN LA VARIABLE GLOBAL
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


    private void startCountdown() {

    }

    private void updateCountdownText() {
        int seconds = (int) (timeLeftInMillis / 1000);
        countdownText.setText(String.valueOf(seconds));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}