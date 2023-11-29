package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.dao.ProductsDao
import com.example.orgs.databinding.ActivityProductListBinding
import com.example.orgs.ui.recyclerView.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {

    private lateinit var bind: ActivityProductListBinding
    private val dao = ProductsDao.getDao()
    private lateinit var adapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // view binding
        bind = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        setupListener()
        setupAdapter()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.findAll())
    }

    private fun setupAdapter() {
        adapter = ProductListAdapter(context = this, products = dao.findAll())
        bind.rvListaProdutos.adapter = adapter
        bind.rvListaProdutos.layoutManager = LinearLayoutManager(this)
    }

    private fun setupListener() {
        bind.fabAdd.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

}