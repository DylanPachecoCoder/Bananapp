package com.fatec.banannap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Cliente(
    val nomeComercio: String,
    val endereco: String,
    val pessoaResponsavel: String,
    val Telefone: String,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0
) : Serializable