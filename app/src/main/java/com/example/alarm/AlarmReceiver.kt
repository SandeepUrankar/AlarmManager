package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.example.alarm")){
            Toast.makeText(context, "Alarm time", Toast.LENGTH_SHORT).show()
        }
    }
}