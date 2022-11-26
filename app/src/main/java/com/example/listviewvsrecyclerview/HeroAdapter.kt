package com.example.listviewvsrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter : BaseAdapter() {
  internal var heroes = arrayListOf<Hero>()

  override fun getCount(): Int = heroes.size

  override fun getItem(i: Int): Any = heroes[i]

  override fun getItemId(i: Int): Long = i.toLong()

  override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
    // menghubungkan ViewHolder dengan view
    val itemView = view ?: LayoutInflater.from(viewGroup.context).inflate(R.layout.item_hero, viewGroup,false )
    val viewHolder = ViewHolder(itemView)

    // mengubah nilai pahlawan sesuai dengan posisinya
    viewHolder.bind(heroes[position])

    return itemView
  }

  private inner class ViewHolder constructor(itemView: View) {
    private val txtName: TextView = itemView.findViewById(R.id.txt_name)
    private val txtDescription: TextView = itemView.findViewById(R.id.txt_description)
    private val imgPhoto: CircleImageView = itemView.findViewById(R.id.img_photo)

    fun bind(hero: Hero) {
      txtName.text = hero.name
      txtDescription.text = hero.description
      imgPhoto.setImageResource(hero.photo)
    }
  }
}