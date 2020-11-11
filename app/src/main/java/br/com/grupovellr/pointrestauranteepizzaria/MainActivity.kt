package br.com.grupovellr.pointrestauranteepizzaria

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        campoImagem.setImageResource(R.drawable.point_login)
        mensagemInicial.setText(R.string.mensageminicial)
        botaoLogin.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    progressBar.visibility = View.GONE
                    val valorUsuario = campoUsuario.text.toString()
                    val valorSenha = campoSenha.text.toString()

                    var lembrar = Prefs.getBoolean("lembrar")
                    if (lembrar) {
                        var lembrarNome  = Prefs.getString("lembrarNome")
                        var lembrarSenha  = Prefs.getString("lembrarSenha")
                        campoUsuario.setText(lembrarNome)
                        campoSenha.setText(lembrarSenha)
                        checkBoxLogin.isChecked = lembrar

                    }

                    Prefs.setBoolean("lembrar", checkBoxLogin.isChecked)

                    if (checkBoxLogin.isChecked) {
                        Prefs.setString("lembrarNome", valorUsuario)
                        Prefs.setString("lembrarSenha", valorSenha)
                    } else{
                        Prefs.setString("lembrarNome", "")
                        Prefs.setString("lembrarSenha", "")
                    }


                    if (valorUsuario == "aluno" && valorSenha == "impacta") {
                        var intent = Intent(this, TelaInicialActivity::class.java)

                        intent.putExtra("nome_usuario", valorUsuario)
                        intent.putExtra("numero", 10)

                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG)
                            .show()
                    }
                    startActivityForResult(intent, 0)
                }, 2000
            )
        }
    }
}

open class DebugActivityActivity {
    fun onCreate(savedInstanceState: Bundle?) {

    }
}
