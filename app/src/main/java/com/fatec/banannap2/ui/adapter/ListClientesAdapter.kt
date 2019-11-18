package com.fatec.banannap2.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatec.banannap2.R
import com.fatec.banannap2.ui.model.Cliente
import kotlinx.android.synthetic.main.item_cliente.view.*

class ListClientesAdapter(private val listaClientes: MutableList<Cliente>,
                          private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cliente = listaClientes[position]
        holder.bindView(cliente)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    fun RecyclerView.ViewHolder.bindView(cliente: Cliente) {
        val nomeCliente = itemView.lista_cliente_nome

        nomeCliente.text = cliente.nomeComercio

    }

}
