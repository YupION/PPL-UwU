package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TransaksiActivity extends AppCompatActivity {
    private RecyclerView recyclerViewtransaksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        recyclerViewtransaksi = findViewById(R.id.recyclerviewtransaksi);
        recyclerViewtransaksi.setHasFixedSize(true);
        recyclerViewtransaksi.setLayoutManager(new LinearLayoutManager(this));
    }
}
