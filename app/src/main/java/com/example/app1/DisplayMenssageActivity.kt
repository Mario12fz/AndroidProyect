package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMenssageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_menssage)

        // Capturamos el valor pasado desde MainActivity
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        // Asignando el valor al textView
        val tvResultado = findViewById<TextView>(R.id.tvMessage).apply {
            text = message
        }
    }
}