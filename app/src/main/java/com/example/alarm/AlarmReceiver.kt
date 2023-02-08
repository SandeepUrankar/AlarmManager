package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("MYTAG", "Receiver is invoked.")
        if(intent!!.action.equals("com.example.alarm")){
            val bundle = intent.extras
            Log.d("MYTAG", "Time is up. ${bundle?.getInt("Hours")}:${bundle?.getInt("Minutes")}")
            Toast.makeText(context, "Time is up. ${bundle?.getInt("Hours")}:${bundle?.getInt("Minutes")}", Toast.LENGTH_LONG).show()

            val notifyme=Notification()
            if (context != null) {
                notifyme.myNotification(context,"Time is up. ${bundle?.getInt("Hours")}:${bundle?.getInt("Minutes")}",10)
            }

        }else if (intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            val saveData=SaveData(context!!)
            saveData.setAlam(saveData.getHour(),saveData.getMin())
        }

    }
}