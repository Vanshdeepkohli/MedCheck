package com.example.medcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText name, phoneNumber, email, password;
    Button signUp;
    TextView logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signUp);
        logIn = (TextView) findViewById(R.id.logIn);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String e = email.getText().toString();
                String pn = phoneNumber.getText().toString();
                String pass = password.getText().toString();
                String HI = "https://www.singhgoodscarrier.com/praveen.php";


                com.android.volley.toolbox.StringRequest stringRequest = new StringRequest(Request.Method.POST, HI, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SignUp.this, "data saved", Toast.LENGTH_LONG).show();
                        //Intent intent = new Intent(login.this,dashboard.class);
                       // startActivity(intent);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUp.this, "data not saved", Toast.LENGTH_LONG).show();
                        //Intent intent = new Intent(registerngo.this,Ngootp.class);
                        // startActivity(intent);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parms = new HashMap<String, String>();
                        parms.put("name", n);
                        parms.put("password", pass);
                        parms.put("phoneNumber", pn);
                        parms.put("email", e);


                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });


    }
}