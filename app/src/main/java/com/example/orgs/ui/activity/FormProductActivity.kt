package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityFormProductBinding
import com.example.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {
    
    private lateinit var bind: ActivityFormProductBinding
    private val dao = ProductsDao.getDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityFormProductBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setupListeners()
    }

    private fun setupListeners() {
        bind.btnSalvar.setOnClickListener {
            createProduct(
                bind.etNome.text.toString(),
                bind.etDescricao.text.toString(),
                bind.etPreco.text.toString()
            )
        }
    }

    private fun createProduct(name: String, description: String, priceText: String) {
        val price = if (priceText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceText)
        }

        val newProduct = Product(name, description, price)
        dao.add(newProduct)

        Log.i("Form Product", "Criado $newProduct")
        Log.i("dao", "${dao.findAll()}")
        finish()
    }
}