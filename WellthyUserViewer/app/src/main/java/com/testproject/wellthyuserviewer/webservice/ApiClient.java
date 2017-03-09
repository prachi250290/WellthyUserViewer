package com.testproject.wellthyuserviewer.webservice;

import com.testproject.wellthyuserviewer.model.User;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by prachi on 05/03/17.
 */

public class ApiClient {

    public static final String BASE_URL = "http://bwellthy.getsandbox.com";

    public static Retrofit getClient() {


        // Interceptor to pass Header Values
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request.Builder builder = chain.request().newBuilder();

                Request request = builder.build();
                return chain.proceed(request);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    
}
