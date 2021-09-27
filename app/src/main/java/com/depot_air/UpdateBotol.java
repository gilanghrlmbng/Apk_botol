package com.depot_air;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.depot_air.adapter.BotolAdapter;
import com.depot_air.model.ResponseErrorModel;
import com.depot_air.rest.ApiConfig;
import com.depot_air.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateBotol extends AppCompatActivity{
    EditText et_merk,et_ukuran,et_harga,et_gambar;
    ImageView gambar_botol;
    Button btnupdate;
    private final String TAG ="retrofit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_botol);

        et_merk = findViewById(R.id.update_merk);
        et_ukuran = findViewById(R.id.update_ukuran);
        et_harga = findViewById(R.id.update_harga);
        et_gambar = findViewById(R.id.update_gambar);
        gambar_botol = findViewById(R.id.gambar);
        btnupdate = findViewById(R.id.btn_update);

        et_gambar.setText(getIntent().getStringExtra(com.depot_air.helper.Bundle.BUNDLE_GAMBAR));
        et_merk.setText(getIntent().getStringExtra(com.depot_air.helper.Bundle.BUNDLE_MERK));
        et_harga.setText(String.valueOf(getIntent().getIntExtra(com.depot_air.helper.Bundle.BUNDLE_HARGA,0)));
        et_ukuran.setText(getIntent().getStringExtra(com.depot_air.helper.Bundle.BUNDLE_UKURAN));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra(com.depot_air.helper.Bundle.BUNDLE_GAMBAR)).error(R.drawable.ic_launcher_foreground).into(gambar_botol);

        btnupdate.setOnClickListener(v -> {
            postUpdate(getIntent().getIntExtra(com.depot_air.helper.Bundle.BUNDLE_ID,0),et_merk.getText().toString().trim(),et_ukuran.getText().toString().trim(),et_harga.getText().toString().trim(),et_gambar.getText().toString().trim());
            et_merk.setText(null);
            et_ukuran.setText(null);
            et_harga.setText(null);
            et_gambar.setText(null);
        });

    }
    private void postUpdate( int id,String merk, String ukuran, String harga, String gambar) {
        ApiService apiService = ApiConfig.getApiService();
        apiService.postUpdate(id,merk,ukuran, harga,gambar)
                .enqueue(new Callback<ResponseErrorModel>() {
                    @Override
                    public void onResponse(Call<ResponseErrorModel> call,
                                           Response<ResponseErrorModel> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: SUKSES > " + response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}