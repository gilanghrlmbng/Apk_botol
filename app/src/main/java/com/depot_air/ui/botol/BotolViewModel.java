package com.depot_air.ui.botol;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.depot_air.model.BotolModel;
import com.depot_air.rest.ApiConfig;
import com.depot_air.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BotolViewModel extends ViewModel {

    private String TAG = "retrofit";
    private MutableLiveData<List<BotolModel>> BotolModelMutableLiveData;
    public LiveData<List<BotolModel>> getTraining(){
        if (BotolModelMutableLiveData == null){
            BotolModelMutableLiveData = new MutableLiveData<List<BotolModel>>();
            laodDataTraining();
        }
        return BotolModelMutableLiveData;
    }
    private void laodDataTraining() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getBotolData().enqueue(new Callback<List<BotolModel>>() {
                    @Override
                    public void onResponse(Call<List<BotolModel>> call,
                                           Response<List<BotolModel>> response) {
                        if (response.isSuccessful()) {
                            BotolModelMutableLiveData.setValue(response.body());
                            Log.d(TAG, "onResponse: " + response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<BotolModel>> call, Throwable t)
                    {
                        Log.d(TAG, "onFailure: " + t.getLocalizedMessage() + "|" +
                                t.getMessage());
                    }
                });
    }
}