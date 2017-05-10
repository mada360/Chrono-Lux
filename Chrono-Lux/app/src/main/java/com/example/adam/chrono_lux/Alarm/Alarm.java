package com.example.adam.chrono_lux.alarm;

/**
 * Created by adam on 19/01/17.
 */

public class Alarm {

    private long id;
    private int hour;
    private int minute;
    private String label;
    private boolean set;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
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

    public Alarm(){

    }

    public Alarm(long id, int alarmTimeHour, int alarmTimeMinute, String label, boolean set) {
        this.id = id;
        this.hour = alarmTimeHour;
        this.minute = alarmTimeMinute;
        this.label = label;
        this.set = set;
    }
}

