package com.misendem.interviewproject.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.misendem.interviewproject.BuildConfig
import com.misendem.interviewproject.data.network.JsonPlaceholderApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import toothpick.config.Module
import java.util.concurrent.TimeUnit

class NetworkModule : Module() {
    init {
        val httpLogging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
        val gson = GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
        val okHttpClient =
            OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLogging)
                .build()
        val appApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(JsonPlaceholderApi::class.java)


        bind(Gson::class.java).toInstance(gson)
        bind(HttpLoggingInterceptor::class.java).toInstance(httpLogging)
        bind(OkHttpClient::class.java).toInstance(okHttpClient)
        bind(JsonPlaceholderApi::class.java).toInstance(appApi)

    }
}