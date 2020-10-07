package br.com.grupovellr.pointrestauranteepizzaria

import android.content.Context

object NovaComandaService {
    fun getNovaComanda (context: Context): List<NovaComanda> {
        val novaComanda = mutableListOf<NovaComanda>()


        for (i in 1..3) {
            val d = NovaComanda()
            d.nome = "Lista de Produtos $i"
            d.foto = "https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0RG000000i2NKVMA2/5cb78ba1e4b04178be5d843c.jpg&w=710&h=462"
            novaComanda.add(d)
        }

        return novaComanda
    }

}