package com.fatec.banannap2.asynctask

import android.os.AsyncTask
import com.fatec.banannap2.model.Cliente

class AtualizaClienteTask(private val cliente: Cliente) : AsyncTask<Void, Void, Cliente>() {

    override fun doInBackground(vararg params: Void?): Cliente {
        return cliente
    }

    override fun onPostExecute(result: Cliente?) {
        super.onPostExecute(result)
    }


}
