package com.depot_air;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.depot_air.model.ResponseErrorModel;
import com.depot_air.rest.ApiConfig;
import com.depot_air.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity{
    EditText uname,pw,mail;
    Button login;
    private String TAG = "retrofit";
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.mail);
        uname = findViewById(R.id.uname);
        pw = findViewById(R.id.pw);
        login = findViewById(R.id.lgn);
        signup = findViewById(R.id.regis);

        login.setOnClickListener(v ->{
            ApiService apiService = ApiConfig.getApiService();
            apiService.login_user(mail.getText().toString().trim(),uname.getText().toString().trim())
                    .enqueue(new Callback<ResponseErrorModel>() {
                        @Override
                        public void onResponse(Call<ResponseErrorModel> call,
                                               Response<ResponseErrorModel> response) {
                            if (response.isSuccessful()) {
                                Log.d(TAG, "onResponse: SUKSES > " + response.body());
                                startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                            Log.d(TAG, "onFailure: " + t.getMessage());
                            Toast.makeText(Login.this, "username atau password salah silahkan diulang", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        signup.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        });
    }

}