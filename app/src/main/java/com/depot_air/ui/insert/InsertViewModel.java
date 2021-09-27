package com.depot_air.ui.insert;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.depot_air.model.ResponseErrorModel;
import com.depot_air.rest.ApiConfig;
import com.depot_air.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertViewModel extends ViewModel {

    private String TAG = "retrofit";
    private MutableLiveData<ResponseErrorModel> responseErrorModelMutableLiveData;
    public LiveData<ResponseErrorModel> postOrders( String merk, String ukuran, String harga, String gambar) {
        if (responseErrorModelMutableLiveData == null) {
            responseErrorModelMutableLiveData = new MutableLiveData<>();
            postOrder(merk, ukuran, harga, gambar);
        }
        return responseErrorModelMutableLiveData;
    }
    private void postOrder( String merk, String ukuran, String harga, String gambar) {
        ApiService apiService = ApiConfig.getApiService();
        apiService.postTambah(merk,ukuran,harga,gambar)
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