package com.goffity.mobile.android.demo.retrofitdemo.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitImplBuilder {

    //  private static final String BASE_URL = "http://159.89.195.61:9080/";
    public static String BASE_URL = "http://127.0.0.11";
    private String TAG = RetrofitImplBuilder.class.getSimpleName();

    public Retrofit create() {
        Log.d(TAG, "create: " + BASE_URL);
        return create(BASE_URL);
    }

    public Retrofit create(String BASE_URL) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
