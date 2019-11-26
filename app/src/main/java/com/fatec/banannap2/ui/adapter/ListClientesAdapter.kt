package com.fatec.banannap2.ui.adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatec.banannap2.R
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.item_cliente.view.*

class ListClientesAdapter(private val listaClientes: MutableList<Cliente>,
                          private val context: Context,
                          val onClick : (Cliente) -> Unit) : RecyclerView.Adapter<ListClientesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cliente = listaClientes[position]
        holder.bindView(cliente, onClick)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {}

        fun bindView(cliente: Cliente, onClick: (Cliente) -> Unit) {
            val nomeCliente = itemView.lista_cliente_nome
            nomeCliente.text = cliente.nomeComercio
            itemView.setOnClickListener{ onClick(cliente) }
            itemView.setOnCreateContextMenuListener(this)

        }
    }
}
