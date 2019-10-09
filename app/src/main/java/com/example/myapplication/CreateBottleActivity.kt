package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val CREATED_BOTTLE_EXTRA_KEY = "1"

class CreateBottleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_bottle)
    }

    fun stopActivityAndReturnResult(view : View) {
        val newName = findViewById<EditText>(R.id.bottleName).text.toString()
        val newPrice = findViewById<EditText>(R.id.bottlePrice).text.toString().toInt()
        val newBottle = Bottle(newName, newPrice)
        val returnIntent = Intent()
        returnIntent.putExtra(CREATED_BOTTLE_EXTRA_KEY, newBottle)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

}
