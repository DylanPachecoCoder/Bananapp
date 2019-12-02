package com.fatec.banannap2.asynctask

import android.os.AsyncTask
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.model.Cliente
import com.fatec.banannap2.ui.adapter.ListClientesAdapter

class BuscaTodosClientesTask(
    private val dao: ClienteDAO,
    private val adapter: ListClientesAdapter
) : AsyncTask<Void, Void, List<Cliente>?>() {

    override fun doInBackground(vararg params: Void?): List<Cliente>? {
        return dao.all()
    }

    override fun onPostExecute(result: List<Cliente>?) {
        super.onPostExecute(result)
        if(result != null){
            adapter.atualiza(result)
        }
    }
}