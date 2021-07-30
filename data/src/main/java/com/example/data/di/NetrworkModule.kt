package com.example.data.di

import com.example.data.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.BuildConfig
import okhttp3.CertificatePinner

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
//object karena kummpulan dari provide
object NetrworkModule {


    @Singleton
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        return loggingInterceptor
    }

    @Provides
    fun hostname() = "https://newsapi.org/v2/";
    //https://newsapi.org/v2/everything?q=tesla&apiKey=&page=2

    @Singleton
    @Provides
    fun certificatePinner(): CertificatePinner = CertificatePinner.Builder()
        .add(hostname(), "sha256/QZ3EWMoTShshKLrh7BRQtxMgBGc/eFICrmJ9b4o6Jh8=")
        .build();

    @Singleton
    @Provides
    fun moshi() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun okhhtpclient() = OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor())
        .certificatePinner(certificatePinner())
        .connectTimeout(20L, TimeUnit.SECONDS)
        .writeTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(20L, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun retrofit() = Retrofit.Builder()
        .baseUrl(hostname())
        .addConverterFactory(MoshiConverterFactory.create(moshi()))
        .client(okhhtpclient())
        .build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit().create(ApiService::class.java)

}