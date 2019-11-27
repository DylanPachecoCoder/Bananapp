package com.fatec.banannap2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fatec.banannap2.model.Cliente

@Dao
interface ClienteDAO {

    @Query("SELECT * FROM cliente")
    fun  all(): List<Cliente>

    @Insert
    fun add(vararg cliente: Cliente)
}