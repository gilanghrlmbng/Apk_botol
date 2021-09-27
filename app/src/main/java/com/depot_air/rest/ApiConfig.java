package com.depot_air.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.16/tugas14/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
