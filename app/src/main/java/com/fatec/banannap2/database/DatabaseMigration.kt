package com.fatec.banannap2.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class DatabaseMigration {

//    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//
//            database.execSQL("ALTER TABLE pin "
//                    + " ADD COLUMN is_location_accurate INTEGER NOT NULL DEFAULT 0")
//            database.execSQL("UPDATE pin "
//                    + " SET is_location_accurate = 0 WHERE lat IS NULL")
//            database.execSQL("UPDATE pin "
//                    + " SET is_location_accurate = 1 WHERE lat IS NOT NULL")
//        }
//    }

}