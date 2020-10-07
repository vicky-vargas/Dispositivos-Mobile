package br.com.grupovellr.pointrestauranteepizzaria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NovaComandaAdapter (
    val novaComanda: List<NovaComanda>,
    val onClick: (NovaComanda) -> Unit): RecyclerView.Adapter<NovaComandaAdapter.NovaComandaViewHolder>() {


    class NovaComandaViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_nova_comanda)
        }
    }

    override fun getItemCount() = this.novaComanda.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovaComandaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_nova_comanda, parent, false)
        val holder = NovaComandaViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: NovaComandaViewHolder, position: Int) {
        val context = holder.itemView.context

        val novaComanda = novaComanda[position]

        holder.cardNome.text = novaComanda.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(novaComanda.foto).fit().into(
            holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        holder.itemView.setOnClickListener {onClick(novaComanda)}
    }
}