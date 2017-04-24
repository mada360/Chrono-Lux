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

import com.example.adam.chrono_lux.alarm.MyAlarmManager;
import com.example.adam.chrono_lux.hue.PHLightManager;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by adam on 06/04/17.
 */

public class MyReceiver extends BroadcastReceiver {

    private PHLightManager lightManager = new PHLightManager();
    private final String TAG = "reciever";


    @Override
    public void onReceive(Context context, Intent intent) {

        createNotification(context, "Times Up", "Light", "Alert");

    }

    private void createNotification(Context context, String msg, String msgTxt, String alert) {

        //getActivity(Context context, int requestCode, Intent intent, int flags)
        PendingIntent notificationIntent = PendingIntent.getActivity(context, 0 , new Intent(context, MainActivity.class), 0);



        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(msg)
                .setContentText(msgTxt)
                .setTicker(alert)
                .setSmallIcon(R.drawable.ic_alarm_add_white_48dp);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        notificationBuilder.setSound(alarmSound);

        if (lightManager.bridgeConnected()) {
            lightManager.randomLights();
        }

        notificationBuilder.setContentIntent(notificationIntent);
        notificationBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, notificationBuilder.build());


    }

}
