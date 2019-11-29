package com.fatec.banannap2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fatec.banannap2.dao.ClienteDAO
import com.fatec.banannap2.model.Cliente

@Database(entities = [Cliente::class], version = 4, exportSchema = false)
abstract class BananappDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDAO

    companion object{
        fun getInstance(context: Context) : BananappDatabase {
            return Room.databaseBuilder(
                context,
                BananappDatabase::class.java,
                "techstore-database"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}