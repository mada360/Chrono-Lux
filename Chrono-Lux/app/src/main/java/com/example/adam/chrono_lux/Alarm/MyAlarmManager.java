package com.example.adam.chrono_lux.Alarm;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 28/02/2017.
 */
public class MyAlarmManager {

    private List<Alarm> alarms = new ArrayList<Alarm>();

    public int getNumberOfAlarm(){
        Log.println(Log.INFO,"Adam", "Alarms " + alarms.size());
        return 0;
    }

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

}
