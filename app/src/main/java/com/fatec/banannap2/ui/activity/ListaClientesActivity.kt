package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.fatec.banannap2.R
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.database.BananappDatabase
import com.fatec.banannap2.ui.adapter.ListClientesAdapter
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.recyclerview_cliente_list.*
import kotlinx.android.synthetic.main.toolbar.*

class ListaClientesActivity : AppCompatActivity() {

    private lateinit var clienteDAO: ClienteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        configuraToolbar()
        configuraDAO()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        configuraListaClientes()
    }

    private fun configuraListaClientes() {
        val listaClientes = clienteDAO.all() as MutableList
        configuraRecyclerView(listaClientes)
    }

    private fun configuraFab() {
        val fab = floatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            val vaiParaCadastraCliente = Intent(this, CadastraClienteActivity::class.java)
            startActivity(vaiParaCadastraCliente)
        })
    }

    private fun configuraRecyclerView(listaClientes: MutableList<Cliente>) {

        val adapter = ListClientesAdapter(listaClientes, this, onClick = {
            val intent = Intent(this, DadosClienteActivity::class.java)
            intent.putExtra("cliente", it)
            startActivity(intent)
        }, clienteDAO = clienteDAO)
        list_clientes_recyclerview.adapter = adapter
        registerForContextMenu(list_clientes_recyclerview)
    }


    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Clientes"
    }

    private fun configuraDAO() {
        val database = Room.databaseBuilder(
            this,
            BananappDatabase::class.java,
            "techstore-database"
        )
            .allowMainThreadQueries()
            .build()
        clienteDAO = database.clienteDao()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
