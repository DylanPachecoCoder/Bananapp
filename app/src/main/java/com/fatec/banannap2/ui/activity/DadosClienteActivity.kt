package com.fatec.banannap2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatec.banannap2.R
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_dados_cliente.*
import kotlinx.android.synthetic.main.toolbar.*

class DadosClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)

        val toolbarid = toolbarid2
        setSupportActionBar(toolbarid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colappsingtoolbar.title = "Dados do Cliente"

        val cliente = intent.getSerializableExtra("cliente") as Cliente

        dados_cliente_textview_nome.text = cliente.nomeComercio
        dados_cliente_textview_endereco.text = cliente.endereco
        dados_cliente_textview_responsavel.text = cliente.pessoaResponsavel
        dados_cliente_textview_telefone.text = cliente.Telefone
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
