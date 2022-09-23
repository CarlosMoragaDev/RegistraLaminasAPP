package com.example.registralaminasapp;

public class Album{

    private int portada;
    private String lNormales;
    private String lEspeciales;

    private String btnDetail;

    public Album(int portada, String lNormales, String lEspeciales, String btnDetail) {
        this.portada = portada;
        this.lNormales = lNormales;
        this.lEspeciales = lEspeciales;
        this.btnDetail = btnDetail;
    }

    public int getPortada() {
        return portada;
    }

    public String getlNormales() {
        return lNormales;
    }

    public String getlEspeciales() {
        return lEspeciales;
    }

    public String getBtnDetail() {
        return btnDetail;
    }
}
