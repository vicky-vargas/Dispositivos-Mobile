package br.com.grupovellr.pointrestauranteepizzaria

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        imagem1.setImageResource(R.drawable.imagem_comanda)
        imagem4.setImageResource(R.drawable.imagen_status_pedido)
        imagem3.setImageResource(R.drawable.imagen_cardapio)

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        val numero = args?.getInt("numero")


        Toast.makeText(this, "Olá $nome", Toast.LENGTH_LONG).show()

        supportActionBar?.title = "Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        botaoPedido.setOnClickListener {
            val intent = Intent(this, AbrirComandaActivity::class.java)
            startActivity(intent)
        }

        botaoPedidos.setOnClickListener {
            val intent = Intent(this, StatusPedidoActivity::class.java)
            startActivity(intent)
        }

        botaoCardapio.setOnClickListener {
            val intent = Intent(this, CardapioActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_config) {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.action_menu_presenter) {
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}