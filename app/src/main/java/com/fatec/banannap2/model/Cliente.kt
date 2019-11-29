package com.fatec.banannap2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Cliente(
    var nomeComercio: String,
    var rua: String,
    var numero : String,
    var bairro : String,
    var cidade : String,
    var pessoaResponsavel: String,
    var telefone: String,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0
) : Serializable