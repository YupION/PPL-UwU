package com.example.sewapaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JsonAdapter extends RecyclerView.Adapter<JsonDataViewHolder> {

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
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_barang,viewGroup,false);

        return new JsonDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder jsonDataViewHolder, int i) {

    JSonDataList currentData = list.get(i);

    jsonDataViewHolder.warna.setText(currentData.getWarna());
    jsonDataViewHolder.harga.setText(currentData.getHarga());
    jsonDataViewHolder.jenis.setText(currentData.getJenis());
    Picasso.get().load(currentData.getImage()).into(jsonDataViewHolder.imageView);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
