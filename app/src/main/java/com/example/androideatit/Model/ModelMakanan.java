package com.example.androideatit.Model;

public class ModelMakanan {

    private String Nama;
    private String MenuId;
    private String Harga;
    private String Gambar;
    private String Diskon;
    private String Deskripsi;

    public ModelMakanan() {
    }

    public ModelMakanan(String nama, String menuId, String harga, String gambar, String diskon, String deskripsi) {
        Nama = nama;
        MenuId = menuId;
        Harga = harga;
        Gambar = gambar;
        Diskon = diskon;
        Deskripsi = deskripsi;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }

    public String getDiskon() {
        return Diskon;
    }

    public void setDiskon(String diskon) {
        Diskon = diskon;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }
}
