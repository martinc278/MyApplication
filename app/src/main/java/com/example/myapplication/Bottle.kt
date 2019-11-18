package com.example.myapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Bottle (@SerializedName("name") val nom: String, @SerializedName("price") val prix: Int) : Serializable{
}