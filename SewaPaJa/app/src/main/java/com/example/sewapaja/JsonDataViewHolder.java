package com.example.sewapaja;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JsonDataViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nama,harga,warna,jenis;

    public JsonDataViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.row_image);
        nama = itemView.findViewById(R.id.row_name);
        harga = itemView.findViewById(R.id.row_harga);
        warna = itemView.findViewById(R.id.row_warna);
        jenis = itemView.findViewById(R.id.row_jenis);


    }
}
