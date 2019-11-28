package com.fatec.banannap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Cliente(
    val nomeComercio: String,
    val rua: String,
    val numero : String,
    val bairro : String,
    val cidade : String,
    val pessoaResponsavel: String,
    val Telefone: String,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0
) : Serializable