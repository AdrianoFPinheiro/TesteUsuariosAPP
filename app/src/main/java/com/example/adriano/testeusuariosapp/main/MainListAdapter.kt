package com.example.adriano.testeusuariosapp.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adriano.testeusuariosapp.R
import com.example.adriano.testeusuariosappp.model.Usuario
import kotlinx.android.synthetic.main.nota_item.view.*

class MainListAdapter(
        val context: Context,
        val usuarios: List<Usuario>,
        val listener: (Usuario) -> Unit,
        val listenerDelete: (Usuario) -> Unit) : RecyclerView.Adapter<MainListAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.nota_item, parent, false)
        return UsuarioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder?.let {
            holder.bindView(usuario, listener, listenerDelete)
        }
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(usuario: Usuario,
                     listener: (Usuario) -> Unit,
                     listenerDelete: (Usuario) -> Unit) = with(itemView) {
            tvUsuario.text = usuario.name
            tvSenha.text = usuario.pwd

            /*ivDelete.setOnClickListener {
                listenerDelete(jogo)
            }*/
            setOnClickListener { listener(usuario) }
        }
    }
}