package com.fatec.banannap2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatec.banannap2.R

class DadosClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)

        title = "Dados do cliente"


    }
}
