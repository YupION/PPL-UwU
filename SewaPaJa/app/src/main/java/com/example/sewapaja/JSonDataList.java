package com.example.sewapaja;

public class JSonDataList {
    String merk,jenis,warna,harga,image,id,desk;

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public String getWarna() {
        return warna;
    }

    public String getHarga() {
        return harga;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getDesk() { return desk;}

    public JSonDataList() {
    }

    public JSonDataList(String id, String merk, String jenis, String warna, String harga, String image, String desk) {
        this.merk = merk;
        this.jenis = jenis;
        this.warna = warna;
        this.harga = harga;
        this.image = image;
        this.id = id;
        this.desk = desk;
    }
}
