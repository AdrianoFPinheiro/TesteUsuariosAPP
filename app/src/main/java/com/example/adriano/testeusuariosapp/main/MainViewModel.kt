package com.example.adriano.testeusuariosapp.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.adriano.testeusuariosapp.repository.UsuarioRepository
import com.example.adriano.testeusuariosappp.model.Usuario


class MainViewModel : ViewModel() {

    val notaRepository = UsuarioRepository()
    val notas: MutableLiveData<List<Usuario>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos() {
        isLoading.value = true
        notaRepository
                .buscarTodos(
                        onComplete = {
                            isLoading.value = false
                            notas.value = it

                        }, onError = {
                    isLoading.value = false
                    notas.value = arrayListOf()
                })

    }

}