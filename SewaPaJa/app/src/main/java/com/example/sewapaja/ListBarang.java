package com.example.sewapaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

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

public class ListBarang extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<JSonDataList> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_barang);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<JSonDataList>();

        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();

    }

    public class JsonFetch extends AsyncTask<String,String,String>{

        HttpURLConnection httpURLConnection = null;
        String mainFile;
        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("https://api.jsonbin.io/b/5e9428a51452b34da0fe670f");
                httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                        stringBuffer.append(line);
                }
                mainFile = stringBuffer.toString();

                JSONArray parent = new JSONArray(mainFile);
                int i =0;

                while (i <= parent.length()){
                    JSONObject child = parent.getJSONObject(i);
                    String img = child.getString("image");
                    String name = child.getString("id");
                    String merk = child.getString("merk");
                    String jenis = child.getString("jenis");
                    String warna = child.getString("warna");
                    String harga = child.getString("harga");

                    arrayList.add(new JSonDataList(merk,jenis,warna,harga,img));
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
