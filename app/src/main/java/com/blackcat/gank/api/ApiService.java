package com.blackcat.gank.api;


import retrofit.Call;
import retrofit.http.GET;

public interface ApiService {

    @GET("http://www.baidu.com")
    Call<String> getBaidu();

}
