package com.example.matorinsearchapp.services;

import com.example.matorinsearchapp.models.SearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleApi {

    String BASE_URL = "https://www.googleapis.com/customsearch/";
    String API_KEY= "AIzaSyCAYroB_5nDsCXvdQ1kO5Nmn2WTwvpgAs8";
    String CX = "018196007796075896583:h3-wuig4uji";

    @GET("v1/")
    Call<SearchModel> getList(@Query("key")String key,@Query("cx")String cx,@Query("q")String q);
}
