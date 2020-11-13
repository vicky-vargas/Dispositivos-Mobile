package br.com.grupovellr.pointrestauranteepizzaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {

    private val TAG = "PointRestauranteePizzaria"
    private val className: String
        get() {
            var s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className onStart() chamado()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className onStart() chamado()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className onResume() chamado()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$className onRestart() chamado()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className onPause() chamado()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className onStop() chamado()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className onDestroy() chamado()")
    }
}