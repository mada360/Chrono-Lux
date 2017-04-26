package com.example.adam.chrono_lux.light;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.example.adam.chrono_lux.R;
import com.philips.lighting.model.PHLight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 28/02/2017.
 */

public class LightAdapter extends ArrayAdapter<PHLight> {


    public LightAdapter(Context context, List<PHLight> lights) {
        super(context, 0 , lights);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PHLight light = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.light, parent, false);
        }
        // Lookup view for data population
        TextView label = (TextView) convertView.findViewById(R.id.light_name);
        TextView type = (TextView) convertView.findViewById(R.id.light_type);
        Switch set = (Switch) convertView.findViewById(R.id.light_switch);
        // Populate the data into the template view using the data object
        label.setText(light.getName());

        set.setChecked(light.getLastKnownLightState().isOn());
        // Return the completed view to render on screen
        return convertView;
    }
}
