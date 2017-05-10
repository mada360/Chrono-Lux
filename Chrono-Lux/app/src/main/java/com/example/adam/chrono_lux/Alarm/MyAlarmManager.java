package com.example.adam.chrono_lux.alarm;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Adam on 28/02/2017.
 */
public class MyAlarmManager {

    private final String TAG = "MyAlarmManager";

    private AlarmDataSource dataSource;

    public MyAlarmManager(Context context){
        dataSource = new AlarmDataSource(context);
    }

    int getNumberOfAlarms(){
        dataSource.open();
        if(dataSource.getAlarms().isEmpty()){
            return 0;
        }

        return dataSource.getAlarms().size();
    }

    void addAlarm(Alarm alarm){
        Log.i(TAG, "addAlarm");
        dataSource.open();
        dataSource.createAlarm(alarm);


    }

    void updateAlarmLabel(int position, String newLabel){
        dataSource.open();
        Alarm alarmToUpdate = getAlarmAtPosition(position);

        dataSource.updateAlarmLabel(alarmToUpdate.getId(), newLabel);

    }

    void setAlarm(int position, boolean toSet){
        dataSource.open();
        Alarm alarmToUpdate = getAlarmAtPosition(position);

        dataSource.updateAlarmSet(alarmToUpdate.getId(), toSet);

    }

    void removeAlarm(int id){
        dataSource.open();

        Alarm alarmToDelete = getAlarmAtPosition(id);

        dataSource.deleteAlarm(alarmToDelete);

    }

    ArrayList<Alarm> getAlarms(){

        if(dataSource != null){
            dataSource.open();

            return dataSource.getAlarms();
        }

        return null;
    }

    public Alarm getAlarmAtPosition(int position){

        ArrayList<Alarm> alarms = getAlarms();

        return alarms.get(position);
    }

    public Alarm getAlarmByID(int id){

        ArrayList<Alarm> alarms = getAlarms();

        for (Alarm alarm: alarms ) {
            if(alarm.getId() == id){
                return alarm;
            }
        }
        return null;
    }
}
