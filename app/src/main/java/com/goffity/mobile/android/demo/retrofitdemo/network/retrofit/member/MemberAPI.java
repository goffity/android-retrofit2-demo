package com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.member;

import com.goffity.mobile.android.demo.retrofitdemo.model.MemberResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MemberAPI {

  @GET("member/view")
  Call<MemberResponse> memberView(@Query("memberid") String memberid);

}
