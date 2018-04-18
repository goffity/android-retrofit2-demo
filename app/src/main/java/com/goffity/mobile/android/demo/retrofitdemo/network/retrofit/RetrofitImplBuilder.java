package com.goffity.mobile.android.demo.retrofitdemo.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitImplBuilder {

  private static final String BASE_URL = "http://159.89.195.61:9080/";

  public Retrofit create() {
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
