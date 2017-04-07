package com.example.adam.chrono_lux.alarm;

/**
 * Created by adam on 19/01/17.
 */

public class Alarm {

    private int time;
    private String label;
    private boolean set;

    public Alarm() {
    }

    public Alarm(String label, boolean set, int time) {
        this.label = label;
        this.set = set;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
