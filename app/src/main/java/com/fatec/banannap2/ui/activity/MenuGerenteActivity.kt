package com.fatec.banannap2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatec.banannap2.R
import com.fatec.banannap2.ui.model.Cliente
import kotlinx.android.synthetic.main.activity_menu_gerente.*
import java.math.BigDecimal

class MenuGerenteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_gerente)

        val botaoPedido = menu_cardview_cliente

        botaoPedido.setOnClickListener { view ->
            val vaiParaClienteActivity = Intent(this, ClienteActivity::class.java)
            startActivity(vaiParaClienteActivity)

        }

    }
}
