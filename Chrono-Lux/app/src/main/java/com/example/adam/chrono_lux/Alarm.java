package com.example.adam.chrono_lux;

import java.util.List;

/**
 * Created by adam on 19/01/17.
 */

public class Alarm {

    private int time;
    private String label;
    private boolean set;

    private List<Alarm> alarms;

    public Alarm(int setTime, String setLabel){

        time = setTime;
        label = setLabel;
        set = true;

        alarms.add(this);
    }

    public Alarm getAlarm(){

        return this;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public int getNumberOfAlarms(){
        return alarms.size();
    }
}
