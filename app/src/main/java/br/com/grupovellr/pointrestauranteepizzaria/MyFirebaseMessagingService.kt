package br.com.grupovellr.pointrestauranteepizzaria

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService: FirebaseMessagingService() {
    val TAG = "firebase"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")

        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")

            showNotification(mensagemRemota)
        }
    }

    private fun showNotification(mensagemRemota: RemoteMessage) {

        val intent = Intent(this, NovaComanda::class.java)
        val titulo = mensagemRemota?.notification?.title?: getString(R.string.app_name)
        var mensagem = mensagemRemota?.notification?.body!!

        if(mensagemRemota?.data.isNotEmpty()) {
            val novaComandaId = mensagemRemota.data.get("novaComandaId")?.toLong()!!
            mensagem += ""
            val novaComanda = NovaComandaService.getNovaComanda(this, novaComandaId)
            intent.putExtra("novaComanda", novaComanda)
        }
        NotificationUtil.create(this, 1, intent, titulo, mensagem)
    }
}