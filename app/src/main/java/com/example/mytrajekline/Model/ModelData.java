package com.example.mytrajekline.Model;

public class ModelData {
    String id_pesan, nama_customer, tgl_pesan, tgl_tour, nama_paket, nama_wisata, harga_paket, harga_total, action;

    public ModelData(){}

    public ModelData(String id_pesan, String nama_customer, String tgl_pesan, String tgl_tour, String nama_paket, String nama_wisata, String harga_paket, String harga_total, String action) {
        this.id_pesan = id_pesan;
        this.nama_customer = nama_customer;
        this.tgl_pesan = tgl_pesan;
        this.tgl_tour = tgl_tour;
        this.nama_paket = nama_paket;
        this.nama_wisata = nama_wisata;
        this.harga_paket = harga_paket;
        this.harga_total = harga_total;
        this.action = action;
    }
    public String getId_pesan() {
        return id_pesan;
    }

    public void setId_pesan(String id_pesan) { this.id_pesan = id_pesan; }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public String getTgl_tour() {
        return tgl_tour;
    }

    public void setTgl_tour(String tgl_tour) {
        this.tgl_tour = tgl_tour;
    }

    public String getNama_paket() { return nama_paket; }

    public void  setNama_paket(String nama_paket) { this.nama_paket = nama_paket; }

    public String getNama_wisata() { return nama_wisata; }

    public void  setNama_wisata(String nama_wisata) { this.nama_wisata = nama_wisata; }

    public String getHarga_paket() { return harga_paket; }

    public void  setHarga_paket(String harga_paket) { this.harga_paket = harga_paket; }

    public String getHarga_total() { return harga_total; }

    public void  setHarga_total(String harga_total) { this.harga_total = harga_total; }

    public String getActiont() { return action; }

    public void  setAction(String action) { this.action = action; }
}
