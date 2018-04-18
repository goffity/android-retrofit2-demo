package com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.login;

import com.goffity.mobile.android.demo.retrofitdemo.model.MemberResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

  @FormUrlEncoded
  @POST("member/login")
  Call<MemberResponse> login(@Field("username") String username, @Field("password") String password);
}
