package com.example.sewapaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewProcessHolder> {
    Context context;
    private ArrayList<ModelData> item;

    public MyAdapter (Context context, ArrayList<ModelData> item){
        this.context = context;
        this.item = item;
    }


    @Override
    public ViewProcessHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.traksaksi_layout, parent,false);
        ViewProcessHolder processHolder = new ViewProcessHolder(view);
        return processHolder;
    }

    @Override
    public void onBindViewHolder(ViewProcessHolder holder, int position) {
        final ModelData data = item.get(position);
        holder.nama_penyewa.setText(data.getNamapenyewa());
        holder.alamat.setText(data.getAlamat());
        holder.nama_barang.setText(data.getNamabarang());
        holder.biaya.setText(data.getBiaya());
        holder.tanggal.setText(data.getTanggal());
        Picasso.get().load(data.getImage()).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }


    public class ViewProcessHolder extends RecyclerView.ViewHolder {
        TextView nama_penyewa,biaya,nama_barang,alamat,tanggal;
        ImageView gambar;

        public ViewProcessHolder(@NonNull View itemView) {
            super(itemView);
            nama_penyewa =itemView.findViewById(R.id.usernamepenyewa);
            gambar = itemView.findViewById(R.id.thumbnailbarang);
            biaya = itemView.findViewById(R.id.biayasewa);
            alamat = itemView.findViewById(R.id.alamatpenyewa);
            nama_barang = itemView.findViewById(R.id.namabarangsewa);
            tanggal = itemView.findViewById(R.id.tanggaltransaksi);
        }
    }
}
