package com.depot_air.model;

public class BotolModel {
    int id, harga;
    String merk_botol, ukuran_botol,gambar;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getMerk_botol() {
        return merk_botol;
    }

    public void setMerk_botol(String merk_botol) {
        this.merk_botol = merk_botol;
    }

    public String getUkuran_botol() {
        return ukuran_botol;
    }

    public void setUkuran_botol(String ukuran_botol) {
        this.ukuran_botol = ukuran_botol;
    }
}
