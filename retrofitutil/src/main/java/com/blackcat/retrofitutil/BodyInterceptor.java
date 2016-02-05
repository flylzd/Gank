package com.blackcat.retrofitutil;


import android.os.Looper;

import com.orhanobut.logger.Logger;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class BodyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response = chain.proceed(request);
        String bodyString = response.body().string();
        Logger.d(bodyString);
//        Logger.json(bodyString);
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), bodyString))
                .build();
    }
}
