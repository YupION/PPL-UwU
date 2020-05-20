package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.Calendar;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    Button btn_sewa;
    String nama_barang,biaya,gambar;
    private ImageView imageView;
    private TextView harga,jenis,warna,merk,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btn_sewa = findViewById(R.id.sewa);
        imageView = findViewById(R.id.detail_pic);
        harga = findViewById(R.id.detil_harga);
        jenis = findViewById(R.id.detil_jenis);
        warna = findViewById(R.id.detil_warna);
        merk = findViewById(R.id.detil_merk);
        id = findViewById(R.id.detil_id);

        final String link = getIntent().getStringExtra("img");
        String link_harga = getIntent().getStringExtra("harga");
        String link_warna = getIntent().getStringExtra("warna");
        String link_jenis = getIntent().getStringExtra("jenis");
        String link_merk = getIntent().getStringExtra("merk");
        final String link_id = getIntent().getStringExtra("id");

        harga.setText(link_harga);
        jenis.setText(link_jenis);
        warna.setText(link_warna);
        merk.setText(link_merk);
        id.setText(link_id);
        Picasso.get().load(link).into(imageView);

        btn_sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama_barang=merk.getText().toString();
                biaya=harga.getText().toString();
                gambar=link;
                Intent intent = new Intent(DetailActivity.this , SewaActivity.class);
                intent.putExtra("NamaBarang",nama_barang);
                intent.putExtra("BIAYA",biaya);
                intent.putExtra("GAMBAR",gambar);
                startActivity(intent);


            }
        });
    }
}
