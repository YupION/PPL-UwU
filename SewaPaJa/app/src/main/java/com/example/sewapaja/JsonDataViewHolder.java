package com.example.sewapaja;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JsonDataViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView id,harga,warna,jenis,merk;

    public JsonDataViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.row_id);
        imageView = itemView.findViewById(R.id.row_image);
        harga = itemView.findViewById(R.id.row_harga);
        warna = itemView.findViewById(R.id.row_warna);
        jenis = itemView.findViewById(R.id.row_jenis);
        merk = itemView.findViewById(R.id.row_name);


    }
}
