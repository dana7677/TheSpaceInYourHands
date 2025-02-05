package com.example.thespaceinyourhands.retrofit

import com.example.thespaceinyourhands.services.NasaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    companion object {
        fun getRetrofit() : NasaService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                //GET https://api.nasa.gov/planetary/apod
            return retrofit.create(NasaService::class.java)
        }
    }
}