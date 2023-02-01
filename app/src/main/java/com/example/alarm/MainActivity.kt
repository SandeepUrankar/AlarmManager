package com.example.alarm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

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
            Snackbar.make(this, findViewById(R.id.cardView),"Choose time to set Alarm. ⏰", Snackbar.ANIMATION_MODE_SLIDE )
                .setAnchorView(R.id.fabAddAlarm)
                .setBackgroundTint(resources.getColor(R.color.background_card))
                .setTextColor(resources.getColor(R.color.white))
                .show()
//            Toast.makeText(this, "Choose time to set Alarm. ⏰", Toast.LENGTH_SHORT).show()
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
        Snackbar.make(fab,"Alarm is set to ${this.selectedHours}:${this.selectedMins}", Snackbar.LENGTH_SHORT )
            .setAction("OK"){}
            .setAnchorView(R.id.fabAddAlarm)
            .setBackgroundTint(resources.getColor(R.color.background_card))
            .setTextColor(resources.getColor(R.color.white))
            .setActionTextColor(resources.getColor(R.color.teal_200))
            .show()
//        Toast.makeText(applicationContext, "${this.selectedHours}:${this.selectedMins}", Toast.LENGTH_SHORT).show()
    }
}