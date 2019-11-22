package com.fatec.banannap2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatec.banannap2.R
import com.fatec.banannap2.model.Cliente
import kotlinx.android.synthetic.main.activity_dados_cliente.*

class DadosClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)

        title = "Dados do cliente"

        val cliente = intent.getSerializableExtra("cliente") as Cliente

        dados_cliente_textview_nome.text = cliente.nomeComercio
        dados_cliente_textview_endereco.text = cliente.endereco
        dados_cliente_textview_responsavel.text = cliente.pessoaResponsavel
        dados_cliente_textview_telefone.text = cliente.Telefone


    }
}
