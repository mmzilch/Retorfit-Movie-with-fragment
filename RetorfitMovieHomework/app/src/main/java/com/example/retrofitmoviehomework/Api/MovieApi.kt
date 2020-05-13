package com.example.retrofitmoviehomework.Api

import com.example.retrofitmoviehomework.Model.Movie
import com.example.retrofitmoviehomework.Model.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {

    private val movieApiInterface:MovieApiInterface

    companion object {
        const val Base_URL="https://api.themoviedb.org/3/movie/"//can call with direct class name
    }

    init {//when create class obj and it create retrofits
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApiInterface=retrofit.create(MovieApiInterface::class.java)
    }

    fun getNews(apiKey : String ): Call<Movie>
    {
        return movieApiInterface.getNews(apiKey)
    }
}