package com.example.listviewvsrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailHeroActivity : AppCompatActivity() {
  companion object{
    const val KEY_HERO = "key_hero"
  }

  @SuppressLint("MissingInflatedId")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_hero)

    val dataHero = intent.getParcelableExtra(KEY_HERO) as Hero?

    if (dataHero != null) {
      findViewById<ImageView>(R.id.imgPhotoDetail).setImageResource(dataHero.photo)
    }

    findViewById<TextView>(R.id.title).text = dataHero?.name
    findViewById<TextView>(R.id.tvDescriptionDetail).text = dataHero?.description
  }
}