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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.sewapaja.LoginActivity.TAG_ID;
import static com.example.sewapaja.LoginActivity.TAG_USERNAME;

public class TransaksiActivity extends AppCompatActivity{
   //private ImageView imgbarang;
   //private TextView namapenyewa,tbiaya,talamat,namabarang,waktutransaksi;
    //SharedPreferences Transaksisharedpreferences;
    public static final String my_shared_preferences = "my_shared_preferences";
    Boolean session = true;
    public static final String session_status = "session_status";
    SharedPreferences sharedpreferences;
   //private RequestQueue requestQueue;
  // private StringRequest stringRequest;
   //private ListView listview;
   private String url2 = Server.URL + "apiTransaksi.php";
    String tag_json_obj = "json_obj_req";
    //private String JSON_STRING;
    private String username,id;
    private RecyclerView mRecyclerView;
    ArrayList<TransaksiDataList> arrayTransaksi;
    ProgressDialog pd;
    //private Object JsonFetch;
    //ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        sharedpreferences= getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, true);
        //username =sharedpreferences.getString(TAG_USERNAME, null);
        //String URL = "https://api.npoint.io/1239447fbdcf5e1a832c";

        //pd = new ProgressDialog(TransaksiActivity.this);
       mRecyclerView = findViewById(R.id.listview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayTransaksi = new ArrayList<TransaksiDataList>();
        JsonFetch transaksifetch = new JsonFetch();
        transaksifetch.execute();
        //listview = findViewById(R.id.listview);

        Intent intent = getIntent();
        username = intent.getStringExtra(Server.TAG_USERNAME);
        //username = sharedpreferences.getString(TAG_USERNAME, null);
        id= sharedpreferences.getString(TAG_ID,null);
        //imgbarang = findViewById(R.id.thumbnailbarang);
        //namapenyewa = findViewById(R.id.usernamepenyewa);
       // tbiaya = findViewById(R.id.biayasewa);
        //talamat = findViewById(R.id.alamatpenyewa);
        //namabarang = findViewById(R.id.namabarangsewa);
       //waktutransaksi = findViewById(R.id.tanggaltransaksi);
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
        //getTransaksi();
}

    public class JsonFetch extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfile;
        @Override
        protected String doInBackground(String... strings) {


            try {
                URL url = new URL("http://192.168.1.2/sewa_barang/apiTransaksi.php?username=");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                //StringRequest
                Requesthandlerr rh = new Requesthandlerr();
                String s = rh.sendGetRequestParam(url,username);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine())!=null){

                    stringBuffer.append(line);
                }

                mainfile = stringBuffer.toString();

                JSONArray parent = new JSONArray(mainfile);
                int i =0;
                while (i<=parent.length()){
                    JSONObject child = parent.getJSONObject(i);
                    String namapenyewatransaksi = child.getString("nama_penyewa");
                    String namabarangtransaksi = child.getString("nama_barang");
                    String imagetransaksi = child.getString("gambar");
                    String waktutransaksi = child.getString("tanggal");
                    String alamattransaksi = child.getString("alamat");
                    String biayatransaksi = child.getString("biaya");
                    //String username = child.getString("username");
                    arrayTransaksi.add(new TransaksiDataList(namapenyewatransaksi, namabarangtransaksi,imagetransaksi, waktutransaksi,alamattransaksi,  biayatransaksi));
                    i++;
                }
            return s;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            TransaksiAdapter transaksiAdapter = new TransaksiAdapter(arrayTransaksi, getApplicationContext(), new MyClick() {
                @Override
                public void onClickMe(View view, int Position) {

                    String link_img_trf = arrayTransaksi.get(Position).getImagetransaksi();
                    String link_biaya_trf = arrayTransaksi.get(Position).getBiayatransaksi();
                    String link_namapenyewa_trf = arrayTransaksi.get(Position).getNamapenyewatransaksi();
                    String link_namabarang_trf = arrayTransaksi.get(Position).getNamabarangtransaksi();
                    String link_alamat = arrayTransaksi.get(Position).getAlamattransaksi();
                    String link_waktu = arrayTransaksi.get(Position).getWaktutransaksi();


                   // Intent i = new Intent(TransaksiActivity.this,DetailActivity.class);
                  //  i.putExtra("img",link_img);
                   // i.putExtra("harga",link_harga);
                   // i.putExtra("warna",link_warna);
                   // i.putExtra("jenis",link_jenis);
                    //i.putExtra("id",link_id);
                   // i.putExtra("merk",link_merk);
                   // i.putExtra("desk",link_desk);
                   // startActivity(i);

                }
            });
            mRecyclerView.setAdapter(transaksiAdapter);



        }
    }
}
