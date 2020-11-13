package br.com.grupovellr.pointrestauranteepizzaria

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object NovaComandaService {

    val host = "https://www.pythonanywhere.com/user/ronicuba/shares/58ce694ae6124654bb1468da303e7adb/"
    val TAG = "WS_PointApp"


    fun getNovaComanda (context: Context): List<NovaComanda> {
        var novaComanda = ArrayList<NovaComanda>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/novaComanda"
            val json = HttpHelper.get(url)
            novaComanda = parserJson(json)

            for (d in novaComanda) {
                saveOffline(d)
            }
            return novaComanda
        } else {
            val dao = DatabaseManager.getNovaComandaDAO()
            val novaComanda = dao.findAll()
            return novaComanda
        }

    }

    fun getNovaComanda (context: Context, id: Long): NovaComanda? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/novaComanda/${id}"
            val json = HttpHelper.get(url)
            val novaComanda = parserJson<NovaComanda>(json)

            return novaComanda
        } else {
            val dao = DatabaseManager.getNovaComandaDAO()
            val novaComanda = dao.getById(id)
            return novaComanda
        }

    }

    fun save(novaComanda: NovaComanda): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/novaComanda", novaComanda.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(novaComanda)
            return Response("OK", "Comanda salva no dispositivo")
        }
    }

    fun saveOffline(novaComanda: NovaComanda) : Boolean {
        val dao = DatabaseManager.getNovaComandaDAO()

        if (! existeNovaComanda(novaComanda)) {
            dao.insert(novaComanda)
        }

        return true

    }

    fun existeNovaComanda(novaComanda: NovaComanda): Boolean {
        val dao = DatabaseManager.getNovaComandaDAO()
        return dao.getById(novaComanda.id) != null
    }

    fun delete(novaComanda: NovaComanda): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/novaComanda/${novaComanda.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getNovaComandaDAO()
            dao.delete(novaComanda)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}