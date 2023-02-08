package com.example.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri.Builder
import android.os.Build
import android.webkit.ConsoleMessage
import androidx.core.app.NotificationCompat
import java.security.AccessControlContext

class Notification() {
    val NOTIFIYTAG="new Request"
    val channelID="notify"
    val description="my alarm"
    lateinit var notificationmanager: NotificationManager
    lateinit var builder: NotificationCompat.Builder
    fun myNotification(context: Context, message: String, number:Int){
        val intent= Intent(context,MainActivity::class.java)
//        val builder=NotificationCompat.Builder(context,channelID)
//            .setSmallIcon(R.drawable.ic_notify)
//            .setContentTitle("Alarm !!!")
//            .setContentText(message)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .setDefaults(android.app.Notification.DEFAULT_ALL)
//            .setContentIntent(PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT))
//            .setAutoCancel(true)
//
//        val note=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ECLAIR)
//        {
//            note.notify(NOTIFIYTAG,0,builder.build())
//        }else{
//            note.notify(NOTIFIYTAG.hashCode(),builder.build())
//        }

        val pendingIntent=PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            var notificationchannel=NotificationChannel(channelID,description,NotificationManager.IMPORTANCE_HIGH)
            notificationchannel.enableLights(true)
            notificationchannel.lightColor=Color.RED
            notificationchannel.enableVibration(true)
            notificationmanager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationmanager.createNotificationChannel(notificationchannel)

            val builder=NotificationCompat.Builder(context,channelID)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentTitle("Alarm !!!")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(android.app.Notification.DEFAULT_ALL)
                .setContentIntent(PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT))
                .setAutoCancel(true)
        }else{
            builder=NotificationCompat.Builder(context,channelID)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentTitle("Alarm !!!")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(android.app.Notification.DEFAULT_ALL)
                .setContentIntent(PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT))
                .setAutoCancel(true)
        }

        notificationmanager.notify(1234,builder.build())


    }



}