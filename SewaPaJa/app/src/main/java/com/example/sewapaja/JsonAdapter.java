package com.example.sewapaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JsonAdapter extends RecyclerView.Adapter<JsonDataViewHolder>{

    ArrayList<JSonDataList> list;
    Context context;

    public JsonAdapter() {
    }

    public JsonAdapter(ArrayList<JSonDataList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       View view = LayoutInflater.from(context).inflate(R.layout.row_barang,parent,false);



        return new JsonDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder holder, int position) {


        JSonDataList currentData = list.get(position);
        holder.id.setText(currentData.getId());
        holder.merk.setText(currentData.getMerk());
        holder.jenis.setText(currentData.getJenis());
        holder.warna.setText(currentData.getWarna());
        holder.harga.setText(currentData.getHarga());
        Picasso.get().load(currentData.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
