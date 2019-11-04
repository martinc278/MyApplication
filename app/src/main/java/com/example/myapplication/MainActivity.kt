package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val CREATE_BOTTLE_REQUEST_CODE = 1
    private val listBottle: ArrayList<Bottle?> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val btnAddBottle = findViewById<Button>(R.id.firstButton)
        btnAddBottle.setOnClickListener {
            val testBottle = Bottle("Chateau MC", 150);
            Toast.makeText(this@MainActivity, "Nom : " + testBottle.nom+" \nPrix : "+testBottle.prix, Toast.LENGTH_LONG).show()
        }*/

    }
    fun addBottleView(view: View) {
        /*val testBottle = Bottle("Chateau MC", 150);
            Toast.makeText(this@MainActivity, "Nom : " + testBottle.nom+" \nPrix : "+testBottle.prix, Toast.LENGTH_LONG).show()
            val newPhoto = findViewById<View>(R.id.imageView)
            newPhoto.setBackgroundResource(R.drawable.axelle)*/
        val intent = Intent(this, CreateBottleActivity::class.java)
        startActivityForResult(intent, CREATE_BOTTLE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_BOTTLE_REQUEST_CODE && data!=null) {
            val bottle: Bottle = data.getSerializableExtra(CREATED_BOTTLE_EXTRA_KEY) as Bottle
            Toast.makeText(this@MainActivity, "Nom : " + bottle.nom+" \nPrix : "+bottle.prix, Toast.LENGTH_LONG).show()
            listBottle.add(bottle)
        }
    }

}