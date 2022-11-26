package com.example.listviewvsrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting ListView
        val listView: ListView = findViewById(R.id.lv_list)
        val adapter = HeroAdapter()
        listView.adapter = adapter

        val recyclerView: RecyclerView = findViewById(R.id.rv_list)
        val recyclerAdapter = RecyclerAdapter()
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // menyiapkan data dari resource
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        // memasukkan data ke data class Hero
        val heroes = arrayListOf<Hero>()

        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )

            heroes.add(hero)
        }

        // memasukkan data class ke adapter
        recyclerAdapter.heroes = heroes

        // memberi aksi pada list
        listView.onItemClickListener = AdapterView.OnItemClickListener {_, _, position, _ ->
            val intent = Intent(this, DetailHeroActivity::class.java)
            intent.putExtra(DetailHeroActivity.KEY_HERO, heroes[position])

            startActivity(intent)
        }
    }
}