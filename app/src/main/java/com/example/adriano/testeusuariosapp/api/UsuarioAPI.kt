package com.example.adriano.testeusuariosapp.api


import com.example.adriano.testeusuariosapp.model.ResponseUser
import com.example.adriano.testeusuariosappp.model.Usuario
import retrofit2.Call
import retrofit2.http.*

interface UsuarioAPI {
    @GET("/pontotel-docs/data.json")
    fun buscarTodos(): Call<ResponseUser>

    @GET("pontotel-docs/data/name/{name}")
    fun buscarPorTitulo(@Path ("name") titulo: String): Call<List<Usuario>>

    @POST("/pontotel-docs")
    fun salvar(@Body usuario: Usuario): Call<Usuario>

    @DELETE("pontotel-docs/data/{id}")
    fun apagar(@Path("id") id: String): Call<Void>

}