package com.blackcat.retrofitutil;


import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

public class StringConverterFactory extends Converter.Factory {

    public static StringConverterFactory create() {
        return new StringConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
//        return super.fromResponseBody(type, annotations);
        return new Converter<ResponseBody, String>() {
            @Override public String convert(ResponseBody value) throws IOException {
                return value.string();
            }
        };
    }

//    @Override
//    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
//        return super.toRequestBody(type, annotations);
//    }
}
