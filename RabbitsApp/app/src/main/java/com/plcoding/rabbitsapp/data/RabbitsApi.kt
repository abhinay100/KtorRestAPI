package com.plcoding.rabbitsapp.data

import retrofit2.http.GET


/**
 * Created by Abhinay on 27/01/25.
 *
 *
 */
interface RabbitsApi {

    @GET("/randomrabbit")
    suspend fun getRandomRabbit(): Rabbit

    companion object {
        const val BASE_URL = "http://192.168.1.10:8080"
    }
}