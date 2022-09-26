package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "message"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}