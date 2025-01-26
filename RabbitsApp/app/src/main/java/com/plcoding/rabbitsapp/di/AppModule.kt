package com.plcoding.rabbitsapp.di

import com.plcoding.rabbitsapp.data.RabbitsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Abhinay on 27/01/25.
 *
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRabbitsApi(): RabbitsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RabbitsApi.BASE_URL)
            .build()
            .create(RabbitsApi::class.java)


    }


}