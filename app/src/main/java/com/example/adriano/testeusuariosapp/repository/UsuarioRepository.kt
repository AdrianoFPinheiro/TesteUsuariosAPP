package com.example.adriano.testeusuariosapp.repository


import com.example.adriano.testeusuariosapp.api.getUsuarioAPI
import com.example.adriano.testeusuariosappp.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsuarioRepository {

    fun buscarTodos(onComplete: (List<Usuario>?) -> Unit,
                    onError: (Throwable?) -> Unit
    ) {
        getUsuarioAPI()
                .buscarTodos()
                .enqueue(object : Callback<List<Usuario>> {
                    override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Usuario>>?, response: Response<List<Usuario>>?) {
                        onComplete(response?.body())
                    }
                })
    }

}