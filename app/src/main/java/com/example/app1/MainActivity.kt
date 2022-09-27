package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar

const val EXTRA_MESSAGE = "message"
class MainActivity : AppCompatActivity() {

    private var toolbar: androidx.appcompat.widget.Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val edtMessage = findViewById<EditText>(R.id.editMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            val edtMessage = findViewById<EditText>(R.id.editMessage)
            if (edtMessage.text.toString().length == 0) {
                Toast.makeText(this, "Enter your Message", Toast.LENGTH_SHORT).show()
            } else {
                // Pasar Contenido a otra actividad a traves de un intent
                val message = edtMessage.text.toString()
                val intent = Intent(this, DisplayMenssageActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                // Iniciamos la otra  actividad
                startActivity(intent)

            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =  when(item.itemId) {
        R.id.item_search -> {
            Toast.makeText(this, "Item search", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_search -> {
            Toast.makeText(this, "Item search", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_share -> {
            Toast.makeText(this, "Item share", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_setting -> {
            Toast.makeText(this, "Item settings", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_exit-> {
            Toast.makeText(this, "Item close App", Toast.LENGTH_SHORT).show()
            true

        }else->{
            super.onOptionsItemSelected(item)
        }
    }
}