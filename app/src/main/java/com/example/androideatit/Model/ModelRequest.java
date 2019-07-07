package com.example.androideatit.Model;

import java.util.List;

public class ModelRequest {
    private String telepon;
    private String nama;
    private String alamat;
    private String total;
    private String status;
    private List<ModelOrder> makanan; // list dari food order

    public ModelRequest() {
    }

    public ModelRequest(String telepon, String nama, String alamat, String total, List<ModelOrder> makanan) {
        this.telepon = telepon;
        this.nama = nama;
        this.alamat = alamat;
        this.total = total;
        this.makanan = makanan;
        this.status = "0"; // Default is 0, 0: Placed, 1: Shipping, 2: Shipped
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ModelOrder> getMakanan() {
        return makanan;
    }

    public void setMakanan(List<ModelOrder> makanan) {
        this.makanan = makanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
