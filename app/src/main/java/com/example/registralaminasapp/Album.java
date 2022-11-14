package com.example.registralaminasapp;

public class Album{

    private int id;
    private String nombre;
    private String normales;
    private String especiales;

    public Album(int id, String nombre, String normales, String especiales) {
        this.id = id;
        this.nombre = nombre;
        this.normales = normales;
        this.especiales = especiales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNormales() {
        return normales;
    }

    public void setNormales(String normales) {
        this.normales = normales;
    }

    public String getEspeciales() {
        return especiales;
    }

    public void setEspeciales(String especiales) {
        this.especiales = especiales;
    }
}
