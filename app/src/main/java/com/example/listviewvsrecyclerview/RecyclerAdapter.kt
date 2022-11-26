package com.example.listviewvsrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
  internal var heroes = arrayListOf<Hero>()

  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtName: TextView = itemView.findViewById(R.id.txt_name)
    private val txtDescription: TextView = itemView.findViewById(R.id.txt_description)
    private val imgPhoto: CircleImageView = itemView.findViewById(R.id.img_photo)

    fun bind(hero: Hero) {
      txtName.text = hero.name
      txtDescription.text = hero.description
      imgPhoto.setImageResource(hero.photo)
      itemView.setOnClickListener {
        val intent = Intent(itemView.context, DetailHeroActivity::class.java)

        intent.putExtra(DetailHeroActivity.KEY_HERO, hero)
        itemView.context.startActivity(intent)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
    holder.bind(heroes[position])
  }

  override fun getItemCount(): Int = heroes.size
}