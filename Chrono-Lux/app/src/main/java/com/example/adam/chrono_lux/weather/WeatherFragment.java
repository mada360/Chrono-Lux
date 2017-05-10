package com.example.adam.chrono_lux.weather;


import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adam.chrono_lux.Fetcher;
import com.example.adam.chrono_lux.R;

import org.json.JSONObject;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Adam on 28/02/2017.
 */

public class WeatherFragment extends Fragment{

    private final String TAG = "WeatherFragment";

    private TextView cityField;
    private TextView updatedField;
    private TextView detailsField;
    private TextView currentTemperatureField;
    private TextView weatherIcon;

    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_view, container, false);

        handler = new Handler();

        cityField = (TextView) view.findViewById(R.id.city);
        updatedField = (TextView) view.findViewById(R.id.updated);
        detailsField = (TextView) view.findViewById(R.id.details);
        currentTemperatureField = (TextView) view.findViewById(R.id.temperature);
        weatherIcon = (TextView) view.findViewById(R.id.weather_icon);

        // Initialize the font object using the ttf font asset.
        Typeface weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weatherfont.ttf");
        updateWeatherData(new CityChanger(getActivity()).getCity());

        weatherIcon.setTypeface(weatherFont);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void changeCity(String city){
        updateWeatherData(city);
    }

    private void updateWeatherData(final String city){
        new Thread(){
            public void run(){
                final JSONObject json = Fetcher.getJSON(getActivity(), city);
                if(json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }


    private void renderWeather(JSONObject json){
        try {
            cityField.setText(json.getString("name").toUpperCase(Locale.UK) +
                    ", " +
                    json.getJSONObject("sys").getString("country"));

            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            JSONObject wind = json.getJSONObject("wind");



            detailsField.setText(
                    details.getString("description") +
                            "\n" + getActivity().getString(R.string.humidity) + main.getString("humidity") + "%" +
                            "\n" + getActivity().getString(R.string.wind_speed) + wind.getString("speed") + " m/sec " +
                            "\n" + getActivity().getString(R.string.pressure) + main.getString("pressure") + " hPa");

            currentTemperatureField.setText(
                    String.format("%s ℃", String.format(Locale.ENGLISH, "%.0f", main.getDouble("temp"))));

            DateFormat df = DateFormat.getDateTimeInstance();
            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
            updatedField.setText(String.format("Last update: %s", updatedOn));

            setWeatherIcon(details.getInt("id"),
                    // Convert time into milliseconds
                    json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000);

        }catch(Exception e){
            Log.e(TAG, "One or more fields not found in the JSON data");
        }
    }

    private void setWeatherIcon(int id, long sunrise, long sunset){

        String icon = "";
        String timeOfDay = "";


        long currentTime = new Date().getTime();
        if(currentTime >= sunrise && currentTime < sunset) {
            timeOfDay = "day_";
        } else {
            timeOfDay = "night_";
        }


        String weatherIconCode = "wi_owm_" + timeOfDay + id;

        Log.i(TAG, weatherIconCode);

        int something = getResources().getIdentifier(weatherIconCode, "string", getContext().getPackageName());

        icon = getActivity().getString(something);

        weatherIcon.setText(icon);
    }
}
