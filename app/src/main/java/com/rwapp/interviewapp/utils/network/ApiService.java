package com.rwapp.interviewapp.utils.network;

import com.rwapp.interviewapp.models.PageWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Purpose: api service url to load data from API
 */
public interface ApiService {
    @GET("test/home")
    Call<PageWrapper> loadData();
}
