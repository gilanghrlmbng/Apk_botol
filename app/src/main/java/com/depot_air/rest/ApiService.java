package com.depot_air.rest;


import com.depot_air.model.BotolModel;
import com.depot_air.model.ResponseErrorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("getbotol.php")
    Call <List<BotolModel>> getBotolData();

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseErrorModel> postRegisterAkun(@Field("username") String username,
                                              @Field("email") String email,
                                              @Field("password") String password);

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseErrorModel> postTambah(@Field("merk_botol") String merk_botol,
                                       @Field("ukuran_botol") String ukuran_botol,
                                       @Field("harga") String harga,
                                       @Field("gambar") String gambar);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseErrorModel> postDelete(@Field("id") int id);

    @GET("login.php")
    Call<ResponseErrorModel> login_user(@Query("email") String email,
                                        @Query("username") String username);

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseErrorModel> postUpdate(@Field("id") int id,
                                        @Field("merk_botol") String merk_botol,
                                        @Field("ukuran_botol") String ukuran_botol,
                                        @Field("harga") String harga,
                                        @Field("gambar") String gambar);
}
