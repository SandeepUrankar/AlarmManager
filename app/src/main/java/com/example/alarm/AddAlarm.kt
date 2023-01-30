package com.example.alarm

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class AddAlarm : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val timePickerView = inflater.inflate(R.layout.add_alarm, container, false)
        val timepicker = timePickerView.findViewById<TimePicker>(R.id.timePicker)
        val doneButton = timePickerView.findViewById<Button>(R.id.btnDone)
        val mainActivity = activity as MainActivity
        var hours = 0
        var mins = 0
        doneButton.setOnClickListener{
            hours = timepicker.hour
            mins = timepicker.minute
            mainActivity.setTime(hours, mins)
            dismiss()
        }
        return timePickerView
    }
}