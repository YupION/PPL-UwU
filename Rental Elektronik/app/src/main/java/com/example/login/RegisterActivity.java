package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android.volley.toolbox.StringRequest;

public class RegisterActivity extends AppCompatActivity {
    private EditText nama,nik,username,telp,alamat,email,password,c_password;
    private Button btn_regist;
    private ProgressBar loading;
    private static String URL_REGIST = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.loading);
        nama = findViewById(R.id.et_nama);
        nik= findViewById(R.id.et_nik);
        username= findViewById(R.id.et_username);
        telp = findViewById(R.id.et_no_telp);
        alamat = findViewById(R.id.et_alamat);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        c_password = findViewById(R.id.et_confirm_password);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });


    }
    private void Regist(){
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);

        final String nama = this.nama.getText().toString().trim();
        final String nik = this.nik.getText().toString().trim();
        final String username = this.username.getText().toString().trim();
        final String telp = this.telp.getText().toString().trim();
        final String alamat = this.alamat.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest()
    }
}
