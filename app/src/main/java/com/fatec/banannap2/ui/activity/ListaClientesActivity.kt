package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        configuraToolbar()
        val listaClientes: MutableList<Cliente> = configuraClientesExemplo()
        configuraRecyclerView(listaClientes)
        configuraFab()
    }

    private fun configuraFab() {
        val fab = floatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            val vaiParaCadastraCliente = Intent(this, CadastraClienteActivity::class.java)
            startActivity(vaiParaCadastraCliente)
        })
    }

    private fun configuraRecyclerView(listaClientes: MutableList<Cliente>) {
        //val recyclerView = list_clientes_recyclerview

        val adapter = ListClientesAdapter(listaClientes, this, onClick = {
            val intent = Intent(this, DadosClienteActivity::class.java)
            intent.putExtra("cliente", it)
            startActivity(intent)
        })
        list_clientes_recyclerview.adapter = adapter
        registerForContextMenu(list_clientes_recyclerview)
    }

    private fun configuraClientesExemplo(): MutableList<Cliente> {
        val listaClientes: MutableList<Cliente> = mutableListOf()

        val mutableListOf = mutableListOf<Cliente>(
            Cliente("Quitanta da Marcia", "Rua x", "Josefina", "9999999"),
            Cliente("Quitanta da Maria", "Rua y", "Maria", "8888888"),
            Cliente("Mercado da esquina", "Rua z", "José", "777777"),
            Cliente("Padaria", "Rua w", "Marcos", "666666"),
            Cliente("Sacolão do Marcello", "Rua a", "Cara simpática", "5555555")
        )

        listaClientes.addAll(mutableListOf)
        return listaClientes
    }

    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Clientes"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Remover")
        alertDialog.setMessage("Deseja remover esta conta ?")
        alertDialog.setPositiveButton("Sim") { _, _ ->
            Toast.makeText(this, "Sim", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("Não") { _, _ ->
            Toast.makeText(this, "Não", Toast.LENGTH_LONG).show()
        }
        alertDialog.show()
        return false
    }
}
