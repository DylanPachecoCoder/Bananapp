package com.fatec.banannap2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.fatec.banannap2.R
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.database.BananappDatabase
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_cadastra_cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastraClienteActivity : AppCompatActivity() {

    private lateinit var clienteDAO: ClienteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_cliente)

        configuraToolbar()
        configuraDAO()
        configuraBotaoSalvar()
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

    private fun configuraBotaoSalvar() {
        val botaoSalvarCliente = botao_salvar_cliente
        botaoSalvarCliente.setOnClickListener {
            val nomeComercio = cadastro_nome_comercio.text.toString()
            val endereco = cadastro_endereco.text.toString()
            val nomeResponsavel = cadastro_nome_responsavel.text.toString()
            val telefone = cadastro_telefone.text.toString()
            val novoCliente = Cliente(nomeComercio, endereco, nomeResponsavel, telefone)
            clienteDAO.add(novoCliente)
            finish()
        }
    }

    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Cadastro Cliente"
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
