package com.goffity.mobile.android.demo.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.goffity.mobile.android.demo.retrofitdemo.R;
import com.goffity.mobile.android.demo.retrofitdemo.model.MemberResponse;
import com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.RetrofitImplBuilder;
import com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.impl.LoginServices;
import com.goffity.mobile.android.demo.retrofitdemo.network.retrofit.member.MemberAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    MemberResponse memberResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginServices loginServices = new LoginServices();
        loginServices.start("goffity@gmail.com", "password");

        Retrofit retrofit = new RetrofitImplBuilder().create();

        MemberAPI memberAPI = retrofit.create(MemberAPI.class);

        final TextView textView = findViewById(R.id.textview1);

        Call<MemberResponse> call = memberAPI.memberView("12");
        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                Log.i(TAG, "onResponse()");
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: success");
                    memberResponse = response.body();
                    Log.d(TAG, "onResponse: " + memberResponse.toString());

                    textView.setText(memberResponse.getMember().getEmail());
                } else {
                    Log.d(TAG, "onResponse: unsuccess");
                }
            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {
                Log.i(TAG, "onFailure()");
                Log.w(TAG, t.getMessage(), t);
            }
        });


//        final TextView textView1 = findViewById(R.id.textview2);
//        final Call<MemberResponse> callAsync = memberAPI.memberView("13");
//
//        new AsyncTask<Void, Void, Void>() {
//
//            Response<MemberResponse> memberResponseResponse;
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                try {
//                    memberResponseResponse = callAsync.execute();
//                    Log.d(TAG, "onCreate:memberResponseResponse " + memberResponseResponse.toString());
//                    Log.d(TAG,
//                            "doInBackground: memberResponseResponse.body().toString(): " + memberResponseResponse
//                                    .body().toString());
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//
//                textView1.setText(memberResponseResponse.body().getMember().getEmail());
//            }
//        }.execute();

        Log.d(TAG, "onCreate: " + memberResponse);

    }
}
