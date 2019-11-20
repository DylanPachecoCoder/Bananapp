package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fatec.banannap2.R
import com.fatec.banannap2.ui.adapter.ListClientesAdapter
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.recyclerview_cliente_list.*

class ListaClientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        title = "Clientes"

        val listaClientes : MutableList<Cliente> = mutableListOf()

        val mutableListOf = mutableListOf<Cliente>(
            Cliente("Quitanta da Marcia"),
            Cliente("Mercado X Loja 1"),
            Cliente("Sergipe"),
            Cliente("Alemão")
            )

        listaClientes.addAll(mutableListOf)

        val recyclerView = list_clientes_recyclerview
        recyclerView.adapter = ListClientesAdapter(listaClientes, this){
            cliente : Cliente ->
            val vaiParaClienteActivity = Intent(this, DadosClienteActivity::class.java)
            startActivity(vaiParaClienteActivity)
        }


        val fab = floatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            val vaiParaCadastraCliente = Intent(this, CadastraClienteActivity::class.java)
            startActivity(vaiParaCadastraCliente)
        })


    }
}
