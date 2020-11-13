package br.com.grupovellr.pointrestauranteepizzaria

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NovaComandaDAO {
    @Query("SELECT * FROM novaComanda where id = :id")
    fun getById(id: Long) : NovaComanda?

    @Query("SELECT * FROM novaComanda")
    fun findAll(): List<NovaComanda>

    @Insert
    fun insert(novaComanda: NovaComanda)

    @Delete
    fun delete(novaComanda: NovaComanda)

}