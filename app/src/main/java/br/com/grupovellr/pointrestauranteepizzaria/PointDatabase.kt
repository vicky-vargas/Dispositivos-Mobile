package br.com.grupovellr.pointrestauranteepizzaria

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NovaComanda::class), version = 1)
abstract class PointDatabase: RoomDatabase() {
    abstract fun novaComandaDAO(): NovaComandaDAO
}