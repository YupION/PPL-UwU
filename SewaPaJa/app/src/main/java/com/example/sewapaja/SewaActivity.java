package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

import static com.example.sewapaja.LoginActivity.TAG_ID;
import static com.example.sewapaja.LoginActivity.TAG_USERNAME;

public class SewaActivity extends AppCompatActivity {
    EditText editnama, editalamat, edittelp, editemail;
    ProgressDialog pDialog;
    TextView txtnamabarang, txthargabarang;
    Button submit;
    private ImageView image;
    SharedPreferences sharedpreferences;
    Intent intent;
    private String url = Server.URL + "transaksi.php";
    String tag_json_obj = "json_obj_req";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG ="SewaActivity";
    int success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa);
        editnama = findViewById(R.id.et_namasewa);
        editalamat = findViewById(R.id.et_alamatsewa);
        editemail = findViewById(R.id.et_emailsewa);
        edittelp = findViewById(R.id.et_notelp);
        txthargabarang = findViewById(R.id.txtbiaya);
        txtnamabarang = findViewById(R.id.txtbarangsewa);
        image = findViewById(R.id.row_image2);
        submit = findViewById(R.id.submit);

        Intent intent = getIntent();
        final String Nama_barang, biaya, gambar;


        gambar = intent.getStringExtra("GAMBAR");
        Nama_barang = intent.getStringExtra("NamaBarang");
        biaya = intent.getStringExtra("BIAYA");


        txthargabarang.setText(biaya);
        txtnamabarang.setText(Nama_barang);
        Picasso.get().load(gambar).into(image);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namasewa = editnama.getText().toString();
                String alamat = editalamat.getText().toString();
                String email = editemail.getText().toString();
                String telp = edittelp.getText().toString();
                String bayar = txthargabarang.getText().toString();
                String namabarang = txtnamabarang.getText().toString();
                checkdata(namasewa, alamat, email, telp, bayar, namabarang,gambar);
            }
        });


    }

    private void checkdata(final String namasewa, final String alamat, final String email, final String telp, final String bayar, final String namabarang, final String gambar) {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Process ...");
        pDialog.setCancelable(false);
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Transaksi Response" + response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);
                    if (success == 1) {

                        Log.e("Successfully Transaksi!", jObj.toString());
                        Intent i = new Intent(SewaActivity.this, ListActivity.class);
                        finish();
                        startActivity(i);

                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        editalamat.setText("");
                        editemail.setText("");
                        editnama.setText("");
                        edittelp.setText("");

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Transaksi Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("namasewa", namasewa);
                params.put("alamat", alamat);
                params.put("email", email);
                params.put("telp", telp);
                params.put("bayar", bayar);
                params.put("namabarang", namabarang);
                params.put("gambar",gambar);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
    public void onBackPressed(){
        intent = new Intent(SewaActivity.this, ListActivity.class);
        finish();
        startActivity(intent);

    }
}

