package com.fatec.banannap2.asynctask

import android.os.AsyncTask
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.model.Cliente
import com.fatec.banannap2.ui.activity.DadosClienteActivity
import kotlinx.android.synthetic.main.activity_dados_cliente.*

class BuscaClienteTask(
    private val dao: ClienteDAO,
    private val cliente: Cliente
) : AsyncTask<Void, Void, Cliente>() {

    override fun doInBackground(vararg params: Void?): Cliente {
        return dao.findById(this.cliente.id)
    }

    override fun onPostExecute(cliente: Cliente) {
        super.onPostExecute(cliente)

        with(DadosClienteActivity()){
            dados_cliente_textview_nome.text = cliente.nomeComercio
            dados_cliente_textview_rua.text = cliente.rua
            dados_cliente_textview_numero.text = cliente.numero
            dados_cliente_textview_bairro.text = cliente.bairro
            dados_cliente_textview_cidade.text = cliente.cidade
            dados_cliente_textview_responsavel.text = cliente.pessoaResponsavel
            dados_cliente_textview_telefone.text = cliente.telefone
        }
    }

}
