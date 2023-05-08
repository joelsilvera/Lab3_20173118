package com.example.lab3_20173118;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ClaseGlobal extends Application {
    private static  List<List<String>> mascotasConSolicitud = new ArrayList<>();

    public static List<List<String>> getmascotasConSolicitud() {
        return mascotasConSolicitud;
    }

    public static void setmascotasConSolicitud(List<List<String>> listas) {
        mascotasConSolicitud = listas;
    }
    public static void agregarMascota(List<String> lista) {
        mascotasConSolicitud.add(lista);
    }

}
