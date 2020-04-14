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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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


            JsonAdapter jsonAdapter = new JsonAdapter(arrayList,getApplicationContext());
            recyclerView.setAdapter(jsonAdapter);



        }
    }
}
