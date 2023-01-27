package com.example.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var fab : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fabAddAlarm)
        fab.setOnClickListener {
            Toast.makeText(this, "Add a new Alarm. ⏰", Toast.LENGTH_SHORT).show()
        }
    }
}