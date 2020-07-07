package com.example.sewapaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiDataViewHolder> {
    ArrayList<TransaksiDataList> list_transaksi;
    Context context_transaksi;
    MyClick myClick;

    public TransaksiAdapter() {

    }

    public TransaksiAdapter(ArrayList<TransaksiDataList> list_transaksi, Context context_transaksi, MyClick myClick) {
        this.myClick = myClick;
        this.list_transaksi = list_transaksi;
        this.context_transaksi = context_transaksi;
    }

    @NonNull
    @Override
    public TransaksiDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context_transaksi).inflate(R.layout.traksaksi_layout, parent, false);
        final TransaksiDataViewHolder TransaksiDataViewHolder = new TransaksiDataViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myClick.onClickMe(view, TransaksiDataViewHolder.getPosition());

            }
        });


        return TransaksiDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiDataViewHolder holder, int position) {
        final TransaksiDataList currentData = list_transaksi.get(position);
        holder.namabarangtransaksi.setText(currentData.getNamabarangtransaksi());
        holder.namapenyewatransaksi.setText(currentData.getNamapenyewatransaksi());
        holder.waktutransaksi.setText(currentData.getWaktutransaksi());
        holder.biayatransaksi.setText(currentData.getBiayatransaksi());
        holder.alamattransaksi.setText(currentData.getAlamattransaksi());
        Picasso.get().load(currentData.getImagetransaksi()).into(holder.imagetransaksi);
    }

    @Override
    public int getItemCount() {
        {
            return list_transaksi.size();
        }
    }
}