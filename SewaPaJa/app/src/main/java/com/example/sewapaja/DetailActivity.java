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
    private TextView mDisplayDatePinjam,mDisplayDateKembali;
    private DatePickerDialog.OnDateSetListener mDateSetListener,mDateSetlistenerKembali;
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

        mDisplayDatePinjam = findViewById(R.id.tgl_pinjam);
        mDisplayDateKembali = findViewById(R.id.tgl_kembali);

        mDisplayDateKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal2 = Calendar.getInstance();
                int year2 = cal2.get(Calendar.YEAR);
                int month2 = cal2.get(Calendar.MONTH);
                int day2 = cal2.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DetailActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetlistenerKembali,year2,month2,day2);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDisplayDatePinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DetailActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;

                Log.d(TAG, "onDataSet: mm/dd/yy : " + month + "/" + day + "/" +year);
                String date = month +"/" + day + "/" + year;
                mDisplayDatePinjam.setText(date);

            }
        };
        mDateSetlistenerKembali = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year2, int month2, int day2) {
                month2 = month2 +1;
                Log.d(TAG, "onDataSet: mm/dd/yy : " + month2 + "/" + day2 + "/" +year2);
                String date2 = month2 +"/" + day2 + "/" + year2;
                mDisplayDateKembali.setText(date2);
            }
        };

        btn_sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this , SewaActivity.class);
                finish();
                startActivity(intent);

            }
        });
    }
}
