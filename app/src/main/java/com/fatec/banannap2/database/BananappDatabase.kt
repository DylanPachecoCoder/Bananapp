package com.fatec.banannap2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.model.Cliente

@Database(entities = [Cliente::class], version = 3, exportSchema = false)
abstract class BananappDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDAO
}