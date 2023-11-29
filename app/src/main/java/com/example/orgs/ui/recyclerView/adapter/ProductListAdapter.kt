package com.example.orgs.ui.recyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Product

class ProductListAdapter(
    products: List<Product>,
    private val context: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun match(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.tv_nome_produto)
            name.text = product.nome

            val descricao = itemView.findViewById<TextView>(R.id.tv_descricao)
            descricao.text = product.descricao

            val preco = itemView.findViewById<TextView>(R.id.tv_preco)
            preco.text = product.preco.toPlainString()
        }
    }

    // faz a bind
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)

        return ViewHolder(view)
    }


    // contagem dos itens
    override fun getItemCount(): Int = products.size


    // qual a posicao do item e qual é o view holder
    // o que vamos fazer com essa informação
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.match(product)
    }

    fun refresh(p: List<Product>) {
        this.products.clear()
        this.products.addAll(p)
        notifyDataSetChanged()
    }


}
