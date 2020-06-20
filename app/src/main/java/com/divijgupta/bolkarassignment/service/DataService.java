package com.divijgupta.bolkarassignment.service;

import com.divijgupta.bolkarassignment.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("android/v1/prod/Radio/hi/show.json")
    Call<List<Response>> getData();
}
