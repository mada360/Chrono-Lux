package com.example.adam.chrono_lux;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by adam on 06/04/17.
 */

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context, "Times Up", "3 Seconds has passed", "Alert");

    }

    private void createNotification(Context context, String msg, String msgTxt, String alert) {
        //getActivity(Context context, int requestCode, Intent intent, int flags)
        PendingIntent notificationIntent = PendingIntent.getActivity(context, 0 , new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(msg)
                .setContentText(msgTxt)
                .setTicker(alert)
                .setSmallIcon(R.drawable.ic_alarm_black_24dp);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        notificationBuilder.setSound(alarmSound);

        notificationBuilder.setContentIntent(notificationIntent);
        notificationBuilder.setAutoCancel(true);



        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, notificationBuilder.build());


    }
}
