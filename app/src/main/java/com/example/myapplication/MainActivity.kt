package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val CREATE_BOTTLE_REQUEST_CODE = 1
    private val listBottle: ArrayList<Bottle> = arrayListOf()
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val btnAddBottle = findViewById<Button>(R.id.firstButton)
        btnAddBottle.setOnClickListener {
            val testBottle = Bottle("Chateau MC", 150);
            Toast.makeText(this@MainActivity, "Nom : " + testBottle.nom+" \nPrix : "+testBottle.prix, Toast.LENGTH_LONG).show()
        }*/

        recyclerView = findViewById<RecyclerView>(R.id.a_rcv_bottles)
        val adapter = BottleAdapter(listBottle)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

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
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

}