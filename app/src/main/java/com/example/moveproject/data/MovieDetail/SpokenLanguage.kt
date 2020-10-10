package com.example.moveproject.data.MovieDetail


import com.google.gson.annotations.SerializedName

data class SpokenLanguage( //มาจาก gson เป็นเกี่ยวกับ ภาษา
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)