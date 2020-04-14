package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<JSonDataList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<JSonDataList>();
        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();

    }

    public class JsonFetch extends AsyncTask<String,String,String>{
        HttpURLConnection httpURLConnection = null;
        String mainfile;
        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("https://api.npoint.io/c3a20da19ca8d9862d0a");
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

                        arrayList.add(new JSonDataList(id,merk,jenis,warna,harga,img));
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
                    Intent i = new Intent(ListActivity.this,DetailActivity.class);
                    i.putExtra("img",link_img);
                    i.putExtra("harga",link_harga);
                    i.putExtra("warna",link_warna);
                    i.putExtra("jenis",link_jenis);
                    i.putExtra("id",link_id);
                    i.putExtra("merk",link_merk);
                    startActivity(i);

                }
            });
            recyclerView.setAdapter(jsonAdapter);



        }
    }
}
