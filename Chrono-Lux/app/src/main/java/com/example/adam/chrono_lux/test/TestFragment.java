package com.example.adam.chrono_lux.test;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.LoginFilter;
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

import static android.content.Context.ALARM_SERVICE;


/**
 * Created by Adam on 28/02/2017.
 */

public class TestFragment extends Fragment implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;

    Button pickTime;

    DateFormat dateFormat = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();
    private TextView testTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_view, container, false);

        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.test_view);

        testTxt = (TextView) view.findViewById(R.id.test_txt);


        pickTime = (Button) view.findViewById(R.id.pick_time_btn);

        pickTime.setOnClickListener(this);

        updateTextLabel();

        final Switch switchBtn = (Switch) view.findViewById(R.id.switch1);

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switchBtn.setText(R.string.on_txt);
                } else {

                    switchBtn.setText(R.string.off_txt);
                }
            }
        });


        return view;
    }

    private void updateTextLabel() {
        testTxt.setText(dateFormat.format(dateTime.getTime()));
    }

    public void addAlarm(){


        updateAlarmCount();
        Snackbar snackbar = Snackbar
                .make(mCoordinatorLayout, "Alarm Added", Snackbar.LENGTH_SHORT);
        snackbar.show();

    }

    public void updateAlarmCount(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pick_time_btn:
                pickTime();
                break;
        }
    }

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            updateTextLabel();
        }
    };

    private void pickTime() {
        new TimePickerDialog(
                getContext(),
                time,
                dateTime.get(Calendar.HOUR_OF_DAY),
                dateTime.get(Calendar.MINUTE),
                true
        ).show();
    }


}
