package com.rwapp.interviewapp.utils.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Purpose: Retrofit client. Calling instance to start HTTP request
 */
public class RetrofitClient {

    private static final String BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/";

    /**
     * Creation of the retrofit instance
     **/
    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Calling for an API service
     **/
    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }

}
