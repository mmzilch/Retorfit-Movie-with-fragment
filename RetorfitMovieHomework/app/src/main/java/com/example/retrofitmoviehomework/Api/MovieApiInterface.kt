package com.example.retrofitmoviehomework.Api

import com.example.retrofitmoviehomework.Model.Movie
import com.example.retrofitmoviehomework.Model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("top_rated")
    fun getNews( @Query("api_key")apiKey : String): Call<Movie>

}