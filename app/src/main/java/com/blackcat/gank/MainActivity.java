package com.blackcat.gank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.gank.api.API;
import com.blackcat.gank.bean.User;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        API.getApiService().getBaidu().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
//                System.out.println(response.body().toString());
                System.out.println("respinse " + response.body().toString());
//                response.body()
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Throwable " + t.toString());
            }
        });

    }


}
