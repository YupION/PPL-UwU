package com.example.sewapaja;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.sewapaja.LoginActivity.TAG_USERNAME;

public class TransaksiActivity extends AppCompatActivity implements View.OnClickListener{
   private ImageView imgbarang;
   private TextView namapenyewa,tbiaya,talamat,namabarang,waktutransaksi;
    SharedPreferences sharedpreferences;
   private RequestQueue requestQueue;
   private StringRequest stringRequest;
   private ListView listview;
    private String JSON_STRING;
    private String username;
    private RecyclerView mRecyclerView;
    ProgressDialog pd;
    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);
        //username = sharedpreferences.getString(TAG_USERNAME, null);
        //String URL = "https://api.npoint.io/1239447fbdcf5e1a832c";

        pd = new ProgressDialog(TransaksiActivity.this);
       // mRecyclerView = findViewById(R.id.listview);
        //mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listview = findViewById(R.id.listview);

        Intent intent = getIntent();
        username = intent.getStringExtra(Server.TAG_USERNAME);
        imgbarang = findViewById(R.id.thumbnailbarang);
        namapenyewa = findViewById(R.id.usernamepenyewa);
        tbiaya = findViewById(R.id.biayasewa);
        talamat = findViewById(R.id.alamatpenyewa);
        namabarang = findViewById(R.id.namabarangsewa);
       waktutransaksi = findViewById(R.id.tanggaltransaksi);
       // requestQueue = Volley.newRequestQueue(TransaksiActivity.this);

        //list_data = new ArrayList<HashMap<String, String>>();

        //stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
       // @Override
        //public void onResponse(String response) {
           // try {
                //JSONObject jsonObject = new JSONObject(response);
                //JSONArray jsonArray = jsonObject.getJSONArray("Barang");
                //for (int a =0 ; a <jsonArray.length();a++){
                   // JSONObject json = jsonArray.getJSONObject(a);
                   // HashMap<String, String> map = new HashMap<String, String>();
                   // map.put("image",json.getString("gambar"));
                    //map.put("namabarang",json.getString("nama_barang"));
                    //map.put("biaya",json.getString("biaya"));
                    //map.put("alamat",json.getString("alamat"));
                   // map.put("tanggal",json.getString("tanggal"));
                    //map.put("namapenyewa",json.getString("nama_penyewa"));
                    //list_data.add(map);
                //}
                //Glide.with(getApplicationContext())
                  //      .load( list_data.get(0).get("gambar"))
                    //    .placeholder(R.mipmap.ic_launcher)
                      //  .into(imgbarang);
                //namapenyewa.setText(list_data.get(0).get("namapenyewa"));
                //biaya.setText(list_data.get(0).get("biaya"));
                //alamat.setText(list_data.get(0).get("alamat"));
                //namabarang.setText(list_data.get(0).get("namabarang"));
                //waktutransaksi.setText(list_data.get(0).get("tanggal"));
            //} catch (JSONException e) {
              //  e.printStackTrace();
            //}

        //}
    //}, new Response.ErrorListener() {
     //   @Override
       // public void onErrorResponse(VolleyError error) {
         //   Toast.makeText(TransaksiActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
        //}
    //});
     //   requestQueue.add(stringRequest);
        getTransaksi();
}

    private void getTransaksi() {
        class GetTransaksi extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TransaksiActivity.this,"Fetching....","Wait....", false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showTransaksi(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                Requesthandlerr rh = new Requesthandlerr();
                String s = rh.sendGetRequestParam(Server.URL_GET_EMP,username);

                return s;
            }
        }
        GetTransaksi gt = new GetTransaksi();
        gt.execute();
    }

    private void showTransaksi(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String name = c.getString(Server.TAG_NAMA);
            String waktu= c.getString(Server.TAG_WAKTU);
            String barang = c.getString(Server.TAG_BARANG);
            String alamat = c.getString(Server.TAG_ALAMAT);
            String biaya = c.getString(Server.TAG_BIAYA);
            String image = c.getString(Server.TAG_IMAGE);

            namapenyewa.setText(name);
            waktutransaksi.setText(waktu);
            namabarang.setText(barang);
            talamat.setText(alamat);
            tbiaya.setText(biaya);
            Picasso.get().load(image).into(imgbarang);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

    }
}
