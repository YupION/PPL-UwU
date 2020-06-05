package com.example.sewapaja;

import android.content.Context;
import android.content.Intent;
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

    MyClick myClick;


    public JsonAdapter() {
    }

    public JsonAdapter(ArrayList<JSonDataList> list, Context context,MyClick myClick) {
        this.myClick = myClick;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       View view = LayoutInflater.from(context).inflate(R.layout.row_barang,parent,false);
        final JsonDataViewHolder jsonDataViewHolder = new JsonDataViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myClick.onClickMe(view,jsonDataViewHolder.getPosition());

            }
        });


        return jsonDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder holder, int position) {


        final JSonDataList currentData = list.get(position);
        holder.id.setText(currentData.getId());
        holder.merk.setText(currentData.getMerk());
        holder.jenis.setText(currentData.getJenis());
        holder.warna.setText(currentData.getWarna());
        holder.harga.setText(currentData.getHarga());
        Picasso.get().load(currentData.getImage()).into(holder.imageView);
        holder.desk.setText(currentData.getDesk());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
