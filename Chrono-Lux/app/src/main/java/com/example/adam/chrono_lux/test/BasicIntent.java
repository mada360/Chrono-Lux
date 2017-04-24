package com.example.adam.chrono_lux.test;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.adam.chrono_lux.alarm.AlarmDataSource;
import com.example.adam.chrono_lux.R;
import com.example.adam.chrono_lux.alarm.Alarm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 06/04/17.
 */

public class BasicIntent extends ListActivity{

    private AlarmDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_test);

        datasource = new AlarmDataSource(this);
        datasource.open();

        List<Alarm> alarms = datasource.getAlarms();

        List<String> values = new ArrayList<>();

        for (Alarm alarm: alarms
             ) {
            values.add(alarm.getLabel());
        }

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Alarm> adapter = (ArrayAdapter<Alarm>) getListAdapter();
        Alarm alarm = null;
        switch (view.getId()) {
            case R.id.add:
                alarm = new Alarm(1,12,10,"foo", false);
                datasource.createAlarm(alarm);
                break;
            case R.id.delete:

                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
