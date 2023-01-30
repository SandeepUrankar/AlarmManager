package com.example.alarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fab : FloatingActionButton
    private lateinit var popupTimePicker: DialogFragment
    private var selectedHours : Int = 0
    private var selectedMins : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fabAddAlarm)
        popupTimePicker = AddAlarm()
        val fragmentManager = supportFragmentManager
        fab.setOnClickListener {
            Toast.makeText(this, "Choose time to set Alarm. ⏰", Toast.LENGTH_SHORT).show()
            popupTimePicker.show(fragmentManager, "Choose time.")
        }
    }


    /**
     * Method to assign the selected hours and minutes from the popup Timepicker.
     *
     * @param selectedHours Int variable to hold the hours selected.
     * @param selectedMins Int variable to hold the minutes selected.
     */
    fun setTime(selectedHours: Int, selectedMins: Int){
        this.selectedHours = selectedHours
        this.selectedMins = selectedMins
        Toast.makeText(applicationContext, "${this.selectedHours}:${this.selectedMins}", Toast.LENGTH_SHORT).show()
    }
}