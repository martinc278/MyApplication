package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CreateBottleFragment.CreateBottleFragmentInteractionListener, BottleListFragment.BottleListFragmentInteractionListener {



    private val CREATE_BOTTLE_REQUEST_CODE = 1
    private val listBottle : ArrayList<Bottle> = arrayListOf()
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayListFragment()

        this.findViewById<Button>(R.id.a_bottle_ist).setOnClickListener{
            displayListFragment()
        }

        this.findViewById<Button>(R.id.a_add_bottle).setOnClickListener{
            displayCreateFragment()
        }

        /*val btnAddBottle = findViewById<Button>(R.id.firstButton)
        btnAddBottle.setOnClickListener {
            val testBottle = Bottle("Chateau MC", 150);
            Toast.makeText(this@MainActivity, "Nom : " + testBottle.nom+" \nPrix : "+testBottle.prix, Toast.LENGTH_LONG).show()
        }*/



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                listBottle.clear()
                displayListFragment()
                true
            }
            R.id.action_favorite -> {
                // User chose the "Favorite" action, mark the current item as a favorite...
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
                true
            }
            // If we got here, the user's action was not recognized.
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun addBottleView(view: View) {
        /*val testBottle = Bottle("Chateau MC", 150);
            Toast.makeText(this@MainActivity, "Nom : " + testBottle.nom+" \nPrix : "+testBottle.prix, Toast.LENGTH_LONG).show()
            val newPhoto = findViewById<View>(R.id.imageView)
            newPhoto.setBackgroundResource(R.drawable.axelle)*/
        val intent = Intent(this, CreateBottleActivity::class.java)
        startActivityForResult(intent, CREATE_BOTTLE_REQUEST_CODE)
    }

    fun displayListFragment(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = BottleListFragment()

        val bundle = Bundle()
        bundle.putSerializable("bottles",listBottle)

        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.fragment_space, fragment)
        fragmentTransaction.commit()
    }

    fun displayCreateFragment(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = CreateBottleFragment()

        fragmentTransaction.replace(R.id.fragment_space, fragment)
        fragmentTransaction.commit()
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_BOTTLE_REQUEST_CODE && data!=null) {
            val bottle: Bottle = data.getSerializableExtra(CREATED_BOTTLE_EXTRA_KEY) as Bottle
            Toast.makeText(this@MainActivity, "Nom : " + bottle.nom+" \nPrix : "+bottle.prix, Toast.LENGTH_LONG).show()
            listBottle.add(bottle)
            recyclerView.adapter?.notifyDataSetChanged()
        }

    }*/

    override fun createBottleFromFragment(bottle: Bottle) {
        listBottle.add(bottle)
        displayListFragment()
    }

    override fun DeleteFromFragment(n: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}