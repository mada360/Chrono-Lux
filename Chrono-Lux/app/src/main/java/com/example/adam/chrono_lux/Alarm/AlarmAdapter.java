package com.example.adam.chrono_lux.alarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.adam.chrono_lux.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Adam on 28/02/2017.
 */

class AlarmAdapter extends ArrayAdapter<Alarm> {

    private final String TAG = "alarmAdapter";

    AlarmAdapter(Context context, ArrayList<Alarm> alarms) {
        super(context, 0 ,alarms);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Alarm alarm = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.alarm_element, parent, false);
        }
        // Lookup view for data population
        TextView label = (TextView) convertView.findViewById(R.id.alarm_label);
        TextView time = (TextView) convertView.findViewById(R.id.alarm_time);
        Switch set = (Switch) convertView.findViewById(R.id.alarm_set);
        // Populate the data into the template view using the data object


        final String timeString = String.format(Locale.UK, "%02d:%02d", alarm.getHour(), alarm.getMinute());
        label.setText(alarm.getLabel());
        time.setText(timeString);
        set.setChecked(alarm.isSet());


        set.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, String.valueOf(position) + " is " + String.valueOf(b));
                MyAlarmManager myAlarmManager = new MyAlarmManager(getContext());
                myAlarmManager.setAlarm(position, b);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}
