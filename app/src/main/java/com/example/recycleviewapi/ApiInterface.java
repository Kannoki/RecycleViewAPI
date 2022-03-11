package com.example.recycleviewapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("newsapi.json")
    Call<List<Article>> getNews();
}
