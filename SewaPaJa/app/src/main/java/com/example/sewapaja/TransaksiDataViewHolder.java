package com.example.sewapaja;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransaksiDataViewHolder extends RecyclerView.ViewHolder {
    ImageView imagetransaksi;
    TextView namabarangtransaksi,namapenyewatransaksi,waktutransaksi,biayatransaksi,alamattransaksi;
    public TransaksiDataViewHolder(@NonNull View itemView) {
        super(itemView);
        imagetransaksi=itemView.findViewById(R.id.thumbnailbarang);
        namabarangtransaksi= itemView.findViewById(R.id.namabarangsewa);
        biayatransaksi=itemView.findViewById(R.id.biayasewa);
        namapenyewatransaksi=itemView.findViewById(R.id.usernamepenyewa);
        alamattransaksi=itemView.findViewById(R.id.alamatpenyewa);
        waktutransaksi=itemView.findViewById(R.id.tanggaltransaksi);

    }
}
