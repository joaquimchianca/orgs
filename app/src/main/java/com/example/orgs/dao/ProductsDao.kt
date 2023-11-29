package com.example.orgs.dao

import com.example.orgs.model.Product

// singleton
class ProductsDao private constructor(){

    private val products = mutableListOf<Product>()

    fun add(p: Product) {
        products.add(p)
    }

    fun findAll(): List<Product> {
        return products.toList()
    }

    companion object {
        private var instance: ProductsDao? = null

        fun getDao(): ProductsDao {
            if (instance == null) {
                instance = ProductsDao()
            }

            return instance!!
        }
    }

}