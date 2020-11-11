package br.com.grupovellr.pointrestauranteepizzaria

import android.app.Application
import java.lang.IllegalStateException

class PointApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: PointApplication?  = null
        fun getInstance(): PointApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}