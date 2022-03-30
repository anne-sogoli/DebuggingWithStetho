package com.annecodes.debuggingwithstetho

import retrofit2.http.GET

interface DogsApiService {
    @GET("image/random")
    suspend fun getRandomDog() : RandomDogResponse
}