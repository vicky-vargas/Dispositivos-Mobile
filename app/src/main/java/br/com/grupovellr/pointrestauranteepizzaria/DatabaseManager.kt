package br.com.grupovellr.pointrestauranteepizzaria

import androidx.room.Room


object DatabaseManager {

    private var dbInstance: PointDatabase
    init {
        val appContext = PointApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
                appContext, // contexto global
                PointDatabase::class.java,
                "point.sqlite"
        ).build()
    }

    fun getNovaComandaDAO(): NovaComandaDAO {
        return dbInstance.novaComandaDAO()
    }
}