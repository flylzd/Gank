package com.blackcat.gank.api;


import com.blackcat.retrofitutil.RetrofitUtil;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class API {

    private static String BASE_URL = "https://api.github.com/";
    private static ApiService apiService;

//    public ApiService getApiService() {
//        if (apiService == null) {
//            synchronized (API.class) {
//                if (apiService == null) {
//
//                    Retrofit retrofit = new Retrofit.Builder()
//                                        .baseUrl(BASE_URL)
//                                        .addConverterFactory(GsonConverterFactory.create())
//                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                                        .build();
//                    apiService = retrofit.create(ApiService.class);
//                }
//            }
//        }
//        return apiService;
//    }



    public static ApiService getApiService() {
        return createApiService(ApiService.class);
    }

    public static <T> T createApiService(Class<T> clazz) {
        return RetrofitUtil.createApiService(clazz,BASE_URL);
    }

}
