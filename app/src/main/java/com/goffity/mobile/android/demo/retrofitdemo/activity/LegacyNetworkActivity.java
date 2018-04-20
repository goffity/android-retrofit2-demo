package com.goffity.mobile.android.demo.retrofitdemo.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.goffity.mobile.android.demo.retrofitdemo.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LegacyNetworkActivity extends AppCompatActivity {

    public static String BASE_URL = "http://www.google.com";
    private String TAG = LegacyNetworkActivity.class.getSimpleName();

    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legacy_network);

        textView = findViewById(R.id.textview);
        textView1 = findViewById(R.id.textview1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: " + BASE_URL);

        new AsyncTask<Void, Void, Void>() {

            Response response;

            @Override
            protected Void doInBackground(Void... voids) {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(BASE_URL).build();


                try {
                    response = okHttpClient.newCall(request).execute();
                    Log.d(TAG, "onResume: " + response.body());


                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                textView.setText(String.valueOf(response.code()));
            }
        }.execute();

        new AsyncTask<Void, Void, Void>() {

            Response response;

            @Override
            protected Void doInBackground(Void... voids) {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(BASE_URL).build();


                try {
                    response = okHttpClient.newCall(request).execute();
                    Log.d(TAG, "onResume: " + response.body());


                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                textView1.setText(String.valueOf(response.code()));
            }
        }.execute();
    }
}
