package com.example.chucknorrisapp.repository

import com.example.chucknorrisapp.network.ChuckNorrisApi
import com.example.chucknorrisapp.network.data.ChuckNorrisRsponse
import retrofit2.Response

class MainRepository() {

    private val chuckNorrisApiService = ChuckNorrisApi

    suspend fun randomJokes():Response<ChuckNorrisRsponse>{
        return chuckNorrisApiService.retrofitService.random()
    }

    suspend fun jokesCategories():Response<List<String>>{
        return  chuckNorrisApiService.retrofitService.categories()
    }

}