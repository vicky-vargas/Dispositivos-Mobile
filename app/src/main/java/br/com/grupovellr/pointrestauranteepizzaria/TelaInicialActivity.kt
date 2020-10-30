package br.com.grupovellr.pointrestauranteepizzaria

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var novaComanda = listOf<NovaComanda>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE= 2

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

        supportActionBar?.title = "Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenulateral()
    }

    private fun configuraMenulateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar_view,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener (this)
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída do PointApp");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_comanda -> {
                val intent = Intent(this, AbrirComandaActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_pedidos -> {
                val intent = Intent(this, StatusPedidoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_cardapio -> {
                val intent = Intent(this, CardapioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_adicionar -> {
                val intent = Intent(this, AdicionarActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_config -> {
                val intent = Intent(this, ConfigActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_sair -> {
                val returnIntent = Intent();
                returnIntent.putExtra("result","Saída do BrewerApp");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.action_config -> {
                val intent = Intent(this, ConfigActivity::class.java)
                startActivity(intent)
            }
            R.id.action_menu_presenter -> {
                val intent = Intent(this, AdicionarActivity::class.java)
                startActivity(intent)
            }

            android.R.id.home-> {
                if(layoutMenuLateral.isDrawerOpen(Gravity.LEFT))
                    layoutMenuLateral.closeDrawer(Gravity.LEFT)
                else
                    layoutMenuLateral.openDrawer(Gravity.LEFT)
            }

        }

        return super.onOptionsItemSelected(item)
    }

}