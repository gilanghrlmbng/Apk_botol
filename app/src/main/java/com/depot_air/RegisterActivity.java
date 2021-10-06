package com.depot_air;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class RegisterActivity extends AppCompatActivity{
    EditText pw,mail,uname,confirmpw;
    private String TAG = "retrofit";
    Button signup;
    TextView login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mail=findViewById(R.id.email);
        uname=findViewById(R.id.uname);
        pw=findViewById(R.id.pw);
        login=findViewById(R.id.txtlogin);
        signup=findViewById(R.id.btnsignup);
        confirmpw = findViewById(R.id.confirmpw);
        sharedPreferences = getSharedPreferences(com.depot_air.helper.Bundle.SHARED_INIT,MODE_PRIVATE);

        signup.setOnClickListener(v -> {
            if (pw.getText().toString().trim().equals(confirmpw.getText().toString().trim())){
                editor = sharedPreferences.edit();
                postRegister(uname.getText().toString().trim(),mail.getText().toString().trim(),pw.getText().toString().trim());
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));

            }else{
                Toast.makeText(this, "Password salah silahkan di input ulang", Toast.LENGTH_SHORT).show();
            }

        });
        login.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(),Login.class));
        });

    }
    private void postRegister( String username, String email, String password) {
        ApiService apiService = ApiConfig.getApiService();
        apiService.postRegisterAkun(username,email,password)
                .enqueue(new Callback<ResponseErrorModel>() {
                    @Override
                    public void onResponse(Call<ResponseErrorModel> call,
                                           Response<ResponseErrorModel> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: SUKSES > " + response.body());
                            editor.putString(com.depot_air.helper.Bundle.SHARED_PRE_UNAME,username);
                            editor.putString(com.depot_air.helper.Bundle.SHARED_PRE_EMAIL,email);
                            editor.apply();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}