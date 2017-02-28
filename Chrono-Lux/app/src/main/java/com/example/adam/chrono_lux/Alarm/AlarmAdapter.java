package com.example.adam.chrono_lux.Alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.adam.chrono_lux.R;

import java.util.ArrayList;

/**
 * Created by Adam on 28/02/2017.
 */

public class AlarmAdapter extends ArrayAdapter<Alarm> {


    public AlarmAdapter(Context context, ArrayList<Alarm> alarms) {
        super(context, 0 ,alarms);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Alarm alarm = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.alarm, parent, false);
        }
        // Lookup view for data population
        TextView label = (TextView) convertView.findViewById(R.id.alarm_label);
        TextView time = (TextView) convertView.findViewById(R.id.alarm_time);
        Switch set = (Switch) convertView.findViewById(R.id.alarm_set);
        // Populate the data into the template view using the data object
        label.setText(alarm.getLabel());
        time.setText(String.valueOf(alarm.getTime()));
        set.setChecked(alarm.isSet());
        // Return the completed view to render on screen
        return convertView;
    }
}
