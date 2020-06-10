package com.example.sewapaja;

public class ModelData {
    String namapenyewa,biaya,tanggal,alamat,namabarang,image;

    public String getNamapenyewa(){
        return namapenyewa;
    }
    public  String getBiaya(){
        return biaya;
    }
    public String getTanggal(){
        return  tanggal;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getNamabarang(){
        return namabarang;
    }
    public String getImage(){
        return image;
    }

    public void setNamapenyewa(String namapenyewa){
       this.namapenyewa = namapenyewa;
    }
    public void setBiaya(String biaya){
       this.biaya=biaya;
    }
    public void setTanggal(String tanggal){
      this.tanggal = tanggal;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public void setNamabarang(String namabarang){
        this.namabarang = namabarang;
    }
    public void setImage(String image){
        this.image = image;
    }

}
