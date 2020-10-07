package br.com.grupovellr.pointrestauranteepizzaria

import java.io.Serializable

class NovaComanda: Serializable {

    var id:Long = 0
    var nome = ""
    var foto = ""

    override fun toString(): String {
        return "$nome"
    }
}