package com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.impl;

import android.util.Log;
import com.goffity.mobile.android.demo.retrofitdemo.model.MemberResponse;
import com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.login.LoginAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginServices implements Callback<MemberResponse> {

  private static final String BASE_URL = "http://159.89.195.61:9080/";
  private String TAG = LoginServices.class.getSimpleName();

  public void start(String username, String password) {
    Log.i(TAG, "start()");

    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    LoginAPI loginAPI = retrofit.create(LoginAPI.class);

    Call<MemberResponse> call = loginAPI.login(username, password);
    call.enqueue(this);
  }

  @Override
  public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
    Log.i(TAG, "onResponse()");

    if (response.isSuccessful()) {
      Log.i(TAG, "onResponse: isSuccessful");

      MemberResponse memberResponse = response.body();
      Log.d(TAG, "onResponse: " + memberResponse.getStatuscode());
      Log.d(TAG, "onResponse: " + memberResponse.getMember().toString());

    }
  }

  @Override
  public void onFailure(Call<MemberResponse> call, Throwable t) {
    Log.i(TAG, "onFailure()");
    Log.e(TAG, t.getMessage(), t);
  }
}
