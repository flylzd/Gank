package com.blackcat.gank.api;


import com.blackcat.gank.bean.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiService {

    @GET("https://api.github.com")
    Call<User> getUser();

    @POST("https://www.baidu.com")
    Call<String> getBaidu();
}
