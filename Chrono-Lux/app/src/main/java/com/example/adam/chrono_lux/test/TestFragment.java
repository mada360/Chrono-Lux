package com.example.adam.chrono_lux.test;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.adam.chrono_lux.MyReceiver;
import com.example.adam.chrono_lux.R;
import com.example.adam.chrono_lux.alarm.Alarm;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Adam on 28/02/2017.
 */

public class TestFragment extends Fragment implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;

    private Button testButton;


    DateFormat dateFormat = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_view, container, false);

        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.test_view);

        testButton = (Button) view.findViewById(R.id.test_btn);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testDB = new Intent(getActivity(), BasicIntent.class);
                final int result = 1;

                startActivityForResult(testDB,result);
            }
        });

        return view;
    }



    @Override
    public void onClick(View view) {

    }
}
