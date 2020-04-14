package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView harga,jenis,warna,merk,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.detail_pic);
        harga = findViewById(R.id.detil_harga);
        jenis = findViewById(R.id.detil_jenis);
        warna = findViewById(R.id.detil_warna);
        merk = findViewById(R.id.detil_merk);
        id = findViewById(R.id.detil_id);

        String link = getIntent().getStringExtra("img");
        String link_harga = getIntent().getStringExtra("harga");
        String link_warna = getIntent().getStringExtra("warna");
        String link_jenis = getIntent().getStringExtra("jenis");
        String link_merk = getIntent().getStringExtra("merk");
        String link_id = getIntent().getStringExtra("id");

        harga.setText(link_harga);
        jenis.setText(link_jenis);
        warna.setText(link_warna);
        merk.setText(link_merk);
        id.setText(link_id);
        Picasso.get().load(link).into(imageView);



    }
}
