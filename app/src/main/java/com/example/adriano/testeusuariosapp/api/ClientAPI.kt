package com.example.adriano.testeusuariosapp.api


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ClientApi<T> {

    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClientAuth().build())
                .baseUrl("https://s3-sa-east-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(c)
    }

}

fun getOkhttpClientAuth(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
}


fun getUsuarioAPI(): UsuarioAPI {
    return ClientApi<UsuarioAPI>().getClient(UsuarioAPI::class.java)
}