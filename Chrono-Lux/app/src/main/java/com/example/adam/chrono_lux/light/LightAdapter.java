package com.example.adam.chrono_lux.light;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.adam.chrono_lux.R;
import com.example.adam.chrono_lux.alarm.MyAlarmManager;
import com.example.adam.chrono_lux.hue.PHLightManager;
import com.philips.lighting.model.PHLight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 28/02/2017.
 */

public class LightAdapter extends ArrayAdapter<PHLight> {

    private final String TAG = "LightAdapter";

    LightAdapter(Context context, List<PHLight> lights) {
        super(context, 0 , lights);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        PHLight light = getItem(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.light, parent, false);
        }
        // Lookup view for data population
        TextView label = (TextView) convertView.findViewById(R.id.light_name);
        ImageView type = (ImageView) convertView.findViewById(R.id.light_type);
        Switch set = (Switch) convertView.findViewById(R.id.light_switch);


        // Populate the data into the template view using the data object
        if (light != null) {
            label.setText(light.getName());

            set.setChecked(light.getLastKnownLightState().isOn());


            // TODO Add more light types
            switch (String.valueOf(light.getLightType())){

                case "DIM_LIGHT":
                    type.setImageResource(R.drawable.ic_white_e27_b22);
                    break;

                case "CT_COLOR_LIGHT":
                    type.setImageResource(R.drawable.ic_white_and_color_e27_b22);
                    break;

                default:
                    type.setImageResource(R.drawable.ic_white_e27_b22);

            }

            type.setColorFilter(Color.argb(255, 255, 255, 255));

        }else{
            label.setText(R.string.unknown_light_name);
        }


        set.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i(TAG, String.valueOf(position) + " is " + String.valueOf(b));
                PHLightManager lightManager = new PHLightManager();

                lightManager.toggleLight(lightManager.getLights().get(position));
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}
