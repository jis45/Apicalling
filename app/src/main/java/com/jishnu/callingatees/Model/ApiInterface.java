package com.jishnu.callingatees.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("register")
    Call<JsonModel> postdata(@Body JsonModel jsonModel);

    @GET("/photos")
    Call<List<DataList>>getAllData();



}
