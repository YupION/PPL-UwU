package com.example.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btn_login, btn_register;
    private ProgressBar loading;
    private static String URL_LOGIN = "http://172.28.1.35/sewa_barang/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loading = findViewById(R.id.loading);
        username = findViewById(R.id.et_layoutusername);
        password = findViewById(R.id.et_layoutpassword);
        btn_login = findViewById(R.id.buttonlogin);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUsername = username.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mUsername.isEmpty() || !mPass.isEmpty()){
                    Login(mUsername, mPass);
                } else {
                    username.setError("Please insert Username");
                    password.setError("Please insert password");
                }
            }
        });
            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                }
            });
     }
     private void Login(final String username, final String password){
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

         StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 try {
                     JSONObject jsonObject = new JSONObject(response);
                     String success = jsonObject.getString("success");
                     JSONArray jsonArray = jsonObject.getJSONArray("login");

                     if(success.equals("1")){
                         for(int i = 0; i < jsonArray.length();i++){
                             JSONObject object = jsonArray.getJSONObject(i);
                             String nama = object.getString("nama").trim();
                             String username = object.getString("username").trim();
                             Toast.makeText(LoginActivity.this, "Success Login. \nYour Name : "+nama+"\nYour Username :"+username, Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                         }
                     }
                 }catch (JSONException e){
                     e.printStackTrace();
                     loading.setVisibility(View.GONE);
                     btn_login.setVisibility(View.VISIBLE);
                     Toast.makeText(LoginActivity.this, "Error" +e.toString(), Toast.LENGTH_SHORT).show();
                 }

             }
         },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         loading.setVisibility(View.GONE);
                         btn_login.setVisibility(View.VISIBLE);
                         Toast.makeText(LoginActivity.this, "Error" +error.toString(), Toast.LENGTH_SHORT).show();
                     }
                 })
         {
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);

                 return params;
             }
         };
         RequestQueue requestQueue = Volley.newRequestQueue(this);
         requestQueue.add(stringRequest);
     }

}
