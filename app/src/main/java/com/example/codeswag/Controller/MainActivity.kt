package com.example.codeswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeswag.Adapters.CategoryAdapter
import com.example.codeswag.Adapters.CategoryRecycleAdapter
import com.example.codeswag.Model.Category
import com.example.codeswag.R
import com.example.codeswag.Services.DataService
import com.example.codeswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
                val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layourManager = LinearLayoutManager(this)
        categoryListView.layoutManager= layourManager
        categoryListView.setHasFixedSize(true)

    }
}
