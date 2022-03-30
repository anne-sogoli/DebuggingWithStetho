package com.annecodes.debuggingwithstetho

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DogsApi {

    const val BASE_URL = "https://dog.ceo/api/breeds/"

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val dogsApi: DogsApiService by lazy {
        retrofit.create(DogsApiService::class.java)
    }
}