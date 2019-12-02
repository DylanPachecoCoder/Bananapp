package com.fatec.banannap2.ui.adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.fatec.banannap2.R
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.item_cliente.view.*

class ListClientesAdapter(
    private val listaClientes: MutableList<Cliente> = mutableListOf(),
    private val context: Context,
    var onClick: (Cliente) -> Unit = {}
) : RecyclerView.Adapter<ListClientesAdapter.ViewHolder>() {

    private lateinit var cliente : Cliente

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        cliente = listaClientes[position]
        holder.bindView(cliente, onClick)
    }

    fun atualiza(cliente: List<Cliente>) {
        notifyItemRangeRemoved(0, this.listaClientes.size)
        this.listaClientes.clear()
        this.listaClientes.addAll(cliente)
        notifyItemRangeInserted(0, this.listaClientes.size)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener {
        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu?.add(0, v!!.id, 0, "Remover")?.setOnMenuItemClickListener {
                var alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("Remover")
                alertDialog.setMessage("Deseja remover este cliente ?")
                alertDialog.setPositiveButton("Sim") { _, _ ->
//                    clienteDAO.remove(cliente)
//                    listaClientes.remove(cliente)
                    notifyDataSetChanged()
                }
                alertDialog.setNegativeButton("Não") { _, _ ->
                }
                alertDialog.show()
                true
            }
        }


        fun bindView(cliente: Cliente, onClick: (Cliente) -> Unit) {
            val nomeCliente = itemView.lista_cliente_nome
            nomeCliente.text = cliente.nomeComercio
            itemView.setOnClickListener { onClick(cliente) }
            itemView.setOnCreateContextMenuListener(this)
        }

    }


}

