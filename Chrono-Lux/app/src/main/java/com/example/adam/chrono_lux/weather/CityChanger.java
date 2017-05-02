package com.example.adam.chrono_lux.weather;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.adam.chrono_lux.R;

/**
 * Created by Adam on 01/05/2017.
 */

public class CityChanger extends FragmentActivity{

    private SharedPreferences prefs;

    private final String TAG = "CityChanger";

    public CityChanger(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);

    }

    // If the user has not chosen a city yet, return London
    String getCity(){
        return prefs.getString("city", "London, UK");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).apply();

    }

}
