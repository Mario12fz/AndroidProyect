package com.example.app1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.app1.databinding.ActivityMainBinding

const val EXTRA_MESSAGE = "message"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var toolbar: androidx.appcompat.widget.Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val btnSend = binding.btnSend

        val edtMessage = findViewById<EditText>(R.id.editMessage)
        btnSend.setOnClickListener{
            val edtMessage = binding.editMessage
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

        binding.btnGetData.setOnClickListener {
            val  edtMennsage = binding.editMessage
            if(edtMessage.text.toString().length > 0){
                binding.tvResult.text = edtMessage.text
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if(newConfig.orientation === Configuration.ORIENTATION_PORTRAIT){
            binding.tvResult.setText("Portrait view")
            Toast.makeText(this, "Postriat", Toast.LENGTH_SHORT).show()

        }else {
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show()
            binding.tvResult.setText("Landscape View")
            }

        }

    }


private fun TextView.setText() {
    TODO("Not yet implemented")
}
