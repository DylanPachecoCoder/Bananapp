package com.fatec.banannap2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.fatec.banannap2.R
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.database.BananappDatabase
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_cadastra_cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class FormularioClienteActivity : AppCompatActivity() {

    private lateinit var clienteDAO: ClienteDAO
    private lateinit var botaoSalvarCliente : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_cliente)
        configuraDAO()
        configuraToolbar()
        botaoSalvarCliente = botao_salvar_cliente

        val quemChamou = identificaSeEditaOuCadastra()
        if(quemChamou){
            colappsingtoolbar.title = "Cadastro Cliente"
            configuraBotaoModoCriaCliente()
        }else{
            colappsingtoolbar.title = "Edita Cliente"
            val cliente = intent.getSerializableExtra("cliente") as Cliente
            preencheCampos(cliente)
        }
    }

    private fun preencheCampos(cliente: Cliente) {
        cadastro_nome_comercio.setText(cliente.nomeComercio)
        cadastro_rua.setText(cliente.rua)
        cadastro_numero.setText(cliente.numero)
        cadastro_bairro.setText(cliente.bairro)
        cadastro_cidade.setText(cliente.cidade)
        cadastro_responsavel.setText(cliente.pessoaResponsavel)
        cadastro_telefone.setText(cliente.Telefone)
    }

    private fun identificaSeEditaOuCadastra(): Boolean {
        val quemChamou = intent.getSerializableExtra("chamado") as Boolean
        return quemChamou
    }

    private fun configuraDAO() {
        val database = Room.databaseBuilder(
            this,
            BananappDatabase::class.java,
            "techstore-database"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        clienteDAO = database.clienteDao()
    }

    private fun configuraBotaoModoCriaCliente() {
        botaoSalvarCliente.setOnClickListener {
            val novoCliente = recebeDadosDoCliente()
            clienteDAO.add(novoCliente)
            finish()
        }
    }

    private fun recebeDadosDoCliente(): Cliente {
        val nomeComercio = cadastro_nome_comercio.text.toString()
        val rua = cadastro_rua.text.toString()
        val numero = cadastro_numero.text.toString()
        val bairro = cadastro_bairro.text.toString()
        val cidade = cadastro_cidade.text.toString()
        val nomeResponsavel = cadastro_responsavel.text.toString()
        val telefone = cadastro_telefone.text.toString()
        val novoCliente =
            Cliente(nomeComercio, rua, numero, bairro, cidade, nomeResponsavel, telefone)
        return novoCliente
    }

    private fun configuraToolbar() {
        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
