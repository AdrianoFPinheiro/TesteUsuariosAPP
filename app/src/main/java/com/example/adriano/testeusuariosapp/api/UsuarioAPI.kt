package com.example.adriano.testeusuariosapp.api


import com.example.adriano.testeusuariosapp.model.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface UsuarioAPI {
    @GET("/pontotel-docs/data.json")
    fun buscarTodos(): Call<ResponseUser>


}