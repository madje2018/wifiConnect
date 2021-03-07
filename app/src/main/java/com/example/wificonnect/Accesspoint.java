package com.example.wificonnect;

public class Accesspoint {
    private String nomAP;
    private String adresseMac;
    private int forceSignal;

    public String getNomAP() {
        return nomAP;
    }

    public void setNomAP(String nomAP) {
        this.nomAP = nomAP;
    }

    public String getAdresseMac() {
        return adresseMac;
    }

    public void setAdresseMac(String adresseMac) {
        this.adresseMac = adresseMac;
    }

    public int getForceSignal() {
        return forceSignal;
    }

    public void setForceSignal(int forceSignal) {
        this.forceSignal = forceSignal;
    }
}
