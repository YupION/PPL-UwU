package com.example.sewapaja;

public class TransaksiDataList {
    String namapenyewatransaksi,namabarangtransaksi,imagetransaksi,waktutransaksi,alamattransaksi,biayatransaksi,username;


    public String getNamapenyewatransaksi() {
        return namapenyewatransaksi;
    }

    public String getNamabarangtransaksi() {
        return namabarangtransaksi;
    }

    public String getImagetransaksi() {
        return imagetransaksi;
    }

    public String getWaktutransaksi() {
        return waktutransaksi;
    }

    public String getAlamattransaksi() {
        return alamattransaksi;
    }

    public String getBiayatransaksi() {
        return biayatransaksi;
    }

    //public String getUsername() {
     //  return username;
  //  }

    public TransaksiDataList(){
    }

    public TransaksiDataList(String namapenyewatransaksi, String namabarangtransaksi,String imagetransaksi, String waktutransaksi, String alamattransaksi, String biayatransaksi/*,String username*/){
        this.namapenyewatransaksi=namapenyewatransaksi;
        this.namabarangtransaksi=namabarangtransaksi;
        this.imagetransaksi=imagetransaksi;
        this.waktutransaksi=waktutransaksi;
        this.alamattransaksi=alamattransaksi;
        this.biayatransaksi=biayatransaksi;
        //this.username=username;
    }
}
