package br.com.grupovellr.pointrestauranteepizzaria

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "novaComanda")
class NovaComanda: Serializable {

    @PrimaryKey
    var id:Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "NovaComanda(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}