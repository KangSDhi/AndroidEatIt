package com.example.androideatit.Model;

public class ModelOrder {

    private String produkId;
    private String produkNama;
    private String Kuantitas;
    private String Harga;
    private String Diskon;

    public ModelOrder() {
    }

    public ModelOrder(String produkId, String produkNama, String kuantitas, String harga, String diskon) {
        this.produkId = produkId;
        this.produkNama = produkNama;
        Kuantitas = kuantitas;
        Harga = harga;
        Diskon = diskon;
    }

    public String getProdukId() {
        return produkId;
    }

    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }

    public String getProdukNama() {
        return produkNama;
    }

    public void setProdukNama(String produkNama) {
        this.produkNama = produkNama;
    }

    public String getKuantitas() {
        return Kuantitas;
    }

    public void setKuantitas(String kuantitas) {
        Kuantitas = kuantitas;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getDiskon() {
        return Diskon;
    }

    public void setDiskon(String diskon) {
        Diskon = diskon;
    }
}
