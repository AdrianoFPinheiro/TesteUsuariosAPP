package com.example.adriano.testeusuariosapp.repository


import com.example.adriano.testeusuariosapp.api.getUsuarioAPI
import com.example.adriano.testeusuariosapp.model.ResponseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsuarioRepository {

    fun buscarTodos(onComplete: (ResponseUser?) -> Unit,
                    onError: (Throwable?) -> Unit
    ) {
        getUsuarioAPI()
                .buscarTodos()
                .enqueue(object: Callback<ResponseUser> {
                    override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                        onComplete(response?.body())
                    }

                })


        
    }

}