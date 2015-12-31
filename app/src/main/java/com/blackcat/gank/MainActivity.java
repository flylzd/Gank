package com.blackcat.gank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.gank.api.API;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        API.getApiService().getBaidu().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


}
