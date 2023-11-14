package com.jishnu.callingatees.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private  static  Retrofit retrofit;
//    private  static  String BASE_URL="http://192.168.1.112:4000/api/";
    private  static  String BASE_URL="https://jsonplaceholder.typicode.com";

//    private Gson gson =new GsonBuilder()
//            .setLenient()
//            .create();




    public static Retrofit getRetrofit() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
////                .addInterceptor(interceptor)
////                .addInterceptor(new TokenInterceptor(context))
//
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
