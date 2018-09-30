package com.example.adriano.testeusuariosapp.api


import com.example.adriano.testeusuariosappp.model.Usuario
import retrofit2.Call
import retrofit2.http.*

interface UsuarioAPI {
    @GET("/nota")
    fun buscarTodos(): Call<List<Usuario>>

    @GET("/usuarios/name/{name}")
    fun buscarPorTitulo(@Path ("name") titulo: String): Call<List<Usuario>>

    @POST("/usuario")
    fun salvar(@Body usuario: Usuario): Call<Usuario>

    @DELETE("/nota/{id}")
    fun apagar(@Path("id") id: String): Call<Void>

}