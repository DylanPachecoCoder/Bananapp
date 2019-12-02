package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fatec.banannap2.R
import com.fatec.banannap2.asynctask.BuscaTodosClientesTask
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.database.BananappDatabase
import com.fatec.banannap2.ui.adapter.ListClientesAdapter
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.recyclerview_cliente_list.*
import kotlinx.android.synthetic.main.toolbar.*

class ListaClientesActivity : AppCompatActivity() {

    private lateinit var clienteDAO: ClienteDAO

    private val adapter by lazy {
        ListClientesAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        configuraToolbar()
        configuraDAO()
        configuraFab()
        configuraRecyclerView()
        buscaClientes()
    }

    private fun buscaClientes() {
        BuscaTodosClientesTask(clienteDAO, adapter).execute()
    }

    override fun onResume() {
        super.onResume()
        buscaClientes()
    }


    private fun configuraFab() {
        val fab = floatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormularioClienteActivity::class.java)
            intent.putExtra("chamado", true)
            startActivity(intent)
        })
    }

    private fun configuraRecyclerView() {
        adapter.onClick = this::abrirDadosCliente
        list_clientes_recyclerview.adapter = adapter

        registerForContextMenu(list_clientes_recyclerview)
    }

    private fun abrirDadosCliente(cliente : Cliente) {
        val intent = Intent(this, DadosClienteActivity::class.java)
        intent.putExtra("cliente", cliente)
        startActivity(intent)
    }


    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Clientes"
    }

    private fun configuraDAO() {
        val database = BananappDatabase.getInstance(this)
        clienteDAO = database.clienteDao()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
