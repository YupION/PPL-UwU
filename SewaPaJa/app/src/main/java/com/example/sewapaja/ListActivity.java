package com.example.sewapaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

public class ListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    ArrayList<JSonDataList> arrayList;
    SharedPreferences sharedpreferences;

    public static final String my_shared_preferences = "my_shared_preferences";
    Boolean session = true;
    public static final String session_status = "session_status";
    private BottomNavigationView menu_bawah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, true);
        recyclerView = findViewById(R.id.recyclerview);
        menu_bawah=findViewById(R.id.menu_bawah);
        menu_bawah.setOnNavigationItemSelectedListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<JSonDataList>();
        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Intent login = new Intent(ListActivity.this, RegisterActivity.class);
                startActivity(login);
                break;
            case R.id.Transaksi:
                Intent transaksi = new Intent(ListActivity.this, SewaActivity.class);
                startActivity(transaksi);
                break;
            case R.id.home:
                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
               break;
            case R.id.logout:
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(session_status, false);
                editor.commit();
                startActivity(new Intent(ListActivity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
        }
        return true;
    }

    public class JsonFetch extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfile;
        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("https://api.npoint.io/2621e10485fe8c564062");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

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
                        String id = child.getString("id_barang");
                        String img = child.getString("image");
                        String merk = child.getString("merk");
                        String jenis = child.getString("jenis");
                        String harga = child.getString("harga");
                        String warna = child.getString("warna");
                        String desk = child.getString("deskripsi");
                        arrayList.add(new JSonDataList(id,merk,jenis,warna,harga,img,desk));
                        i++;
                    }

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


            JsonAdapter jsonAdapter = new JsonAdapter(arrayList, getApplicationContext(), new MyClick() {
                @Override
                public void onClickMe(View view, int Position) {

                    String link_img = arrayList.get(Position).getImage();
                    String link_harga = arrayList.get(Position).getHarga();
                    String link_warna = arrayList.get(Position).getWarna();
                    String link_jenis = arrayList.get(Position).getJenis();
                    String link_id = arrayList.get(Position).getId();
                    String link_merk = arrayList.get(Position).getMerk();
                    String link_desk = arrayList.get(Position).getDesk();

                    Intent i = new Intent(ListActivity.this,DetailActivity.class);
                    i.putExtra("img",link_img);
                    i.putExtra("harga",link_harga);
                    i.putExtra("warna",link_warna);
                    i.putExtra("jenis",link_jenis);
                    i.putExtra("id",link_id);
                    i.putExtra("merk",link_merk);
                    i.putExtra("desk",link_desk);
                    startActivity(i);

                }
            });
            recyclerView.setAdapter(jsonAdapter);



        }
    }
}
