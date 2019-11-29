package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room
import com.fatec.banannap2.R
import com.fatec.banannap2.database.BananappDatabase
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_dados_cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class DadosClienteActivity : AppCompatActivity() {

    lateinit var cliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)
        configuraToolbar()
        cliente = recebeDadosDoCliente()
        preencheDadosDoCliente(cliente)
    }

    override fun onResume() {
        super.onResume()
        val database = BananappDatabase.getInstance(this)
        val clienteDAO = database.clienteDao()
        val listaClientes = clienteDAO.all()
        for (cliente : Cliente in listaClientes){
            if(this.cliente.id == cliente.id){
                preencheDadosDoCliente(cliente)
                break
            }
        }

    }

    private fun preencheDadosDoCliente(cliente: Cliente) {
        dados_cliente_textview_nome.text = cliente.nomeComercio
        dados_cliente_textview_rua.text = cliente.rua
        dados_cliente_textview_numero.text = cliente.numero
        dados_cliente_textview_bairro.text = cliente.bairro
        dados_cliente_textview_cidade.text = cliente.cidade
        dados_cliente_textview_responsavel.text = cliente.pessoaResponsavel
        dados_cliente_textview_telefone.text = cliente.telefone
    }

    private fun recebeDadosDoCliente(): Cliente {
        val cliente = intent.getSerializableExtra("cliente") as Cliente
        return cliente
    }

    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Dados do Cliente"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_cadastra_cliente_editar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemSelecionado = item.itemId
        if(itemSelecionado == R.id.activity_cadastra_cliente_editar){
            val intent = Intent(this, FormularioClienteActivity::class.java)
            intent.putExtra("chamado", false)
            intent.putExtra("cliente", cliente)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
