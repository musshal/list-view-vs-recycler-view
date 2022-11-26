package com.example.listviewvsrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero (
  var photo: Int,
  var name: String,
  var description: String
  ) : Parcelable