package com.example.sewapaja;

public class JSonDataList {
    private String merk,jenis,warna,harga,image;

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

    public JSonDataList() {

    }

    public JSonDataList(String merk, String jenis, String warna, String harga, String image) {
        this.merk = merk;
        this.jenis = jenis;
        this.warna = warna;
        this.harga = harga;
        this.image = image;
    }
}
