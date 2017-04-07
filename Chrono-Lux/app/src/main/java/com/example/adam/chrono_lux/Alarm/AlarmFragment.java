package com.example.adam.chrono_lux.alarm;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adam.chrono_lux.R;

import java.util.ArrayList;


/**
 * Created by Adam on 28/02/2017.
 */

public class AlarmFragment extends Fragment {


    private ArrayList<Alarm> alarms = new ArrayList<Alarm>();

    private CoordinatorLayout mCoordinatorLayout;

    private Alarm test = new Alarm("Test", true, 700);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alarm_view, container, false);

        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.alarm_view);



        alarms.add(test);

        TextView numberofalarms = (TextView) view.findViewById(R.id.number_of_alarms_txt);

        String num = String.valueOf(alarms.size());
        numberofalarms.setText("Number of alarms is: " + num);

        FloatingActionButton addAlarmBtn = (FloatingActionButton) view.findViewById(R.id.add_alarm);

        addAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAlarm();
            }
        });

        ListAdapter theAdapter = new AlarmAdapter(getActivity().getApplicationContext(), alarms);

        ListView theListView = (ListView) view.findViewById(R.id.alarmlist);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(position));
                Snackbar.make(mCoordinatorLayout, selected, Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    public void addAlarm(){

        alarms.add(test);
        updateAlarmCount();
        Snackbar snackbar = Snackbar
                .make(mCoordinatorLayout, "Alarm Added", Snackbar.LENGTH_SHORT)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alarms.remove(alarms.size()-1);
                        updateAlarmCount();
                        Snackbar snackbar1 = Snackbar.make(mCoordinatorLayout, "Alarm Deleted", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.show();

    }

    public void updateAlarmCount(){
        View view = getView();
        if(view != null) {
            TextView numberofalarms = (TextView) view.findViewById(R.id.number_of_alarms_txt);

            try {
                String num = String.valueOf(alarms.size());
                numberofalarms.setText("Number of alarms is: " + num);


            } catch (Exception e) {
                Log.println(Log.INFO, "Adam", e.toString());
            }
        }
    }

}
