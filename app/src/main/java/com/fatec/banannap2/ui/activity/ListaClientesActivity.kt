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
import kotlinx.android.synthetic.main.toolbar.*

class ListaClientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Clientes"

        val listaClientes : MutableList<Cliente> = mutableListOf()

        val mutableListOf = mutableListOf<Cliente>(
            Cliente("Quitanta da Marcia", "Rua x", "Josefina", "9999999"),
            Cliente("Quitanta da Maria", "Rua y", "Maria", "8888888"),
            Cliente("Mercado da esquina", "Rua z", "José", "777777"),
            Cliente("Padaria", "Rua w", "Marcos", "666666"),
            Cliente("Sacolão do Marcello", "Rua a", "Cara simpática", "5555555")
            )

        listaClientes.addAll(mutableListOf)

        val recyclerView = list_clientes_recyclerview
        recyclerView.adapter = ListClientesAdapter(listaClientes, this, onClick = {
            val intent = Intent(this, DadosClienteActivity::class.java)
            intent.putExtra("cliente", it)
            startActivity(intent)
        })

        val fab = floatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            val vaiParaCadastraCliente = Intent(this, CadastraClienteActivity::class.java)
            startActivity(vaiParaCadastraCliente)
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
