package com.example.adam.chrono_lux.alarm;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.adam.chrono_lux.MyReceiver;
import com.example.adam.chrono_lux.R;


/**
 * Created by Adam on 28/02/2017.
 */

public class AlarmFragment extends Fragment {

    private final String TAG = "alarmFragment";

    private CoordinatorLayout mCoordinatorLayout;

    private Alarm test = new Alarm(0, 7, 0, "", true);

    private MyAlarmManager myAlarmManager;
    private AlarmAdapter alarmAdapter;
    private Calendar dateTime = Calendar.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the view of the Alarm fragment
        View view = inflater.inflate(R.layout.alarm_view, container, false);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.alarm_view);

        // Create an alarm manager if there isn't one already to prevent multiple being created.
        if (myAlarmManager == null) {
            myAlarmManager = new MyAlarmManager(getContext());
        }

        // Add an alarm_element if none for testing
        if (myAlarmManager.getNumberOfAlarms() < 1) {
            myAlarmManager.addAlarm(test);
        }


        // The alarmAdpater is used to obtain the list of alarms from the alarm manager
        alarmAdapter = new AlarmAdapter(getActivity().getApplicationContext(), myAlarmManager.getAlarms());

        final ListView alarmListView = (ListView) view.findViewById(R.id.alarm_list_view);
        alarmListView.setAdapter(alarmAdapter);

        FloatingActionButton addAlarmBtn = (FloatingActionButton) view.findViewById(R.id.add_alarm);

        addAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAlarm();
            }
        });


        // Set the click listeners for the alarm items from the list.
        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {



               /* final TextView alarmTime = (TextView) view.findViewById(R.id.alarm_time);

                alarmTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, alarmTime.getText().toString());
                        // TODO STRETCH - implement change time, currently will create a new alarm.
                        //pickTime();
                    }
                });*/


                // Change the label of the alarm at the pressed position
                changeLabel(position);


            }
        });

        alarmListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> adapterView, View view, final int position, long l) {

                deleteAlarmDialog(position);
                return true;
            }
        });

        return view;
    }


    private void pickTime() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getContext(),
                time,
                dateTime.get(Calendar.HOUR_OF_DAY),
                dateTime.get(Calendar.MINUTE),
                true // Use 24 hour view
        );
        timePickerDialog.setTitle("Set Alarm Time");
        timePickerDialog.show();

    }

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);

            // TODO - This currently will add a new alarm if time is changed and will leave the old one in place.
            delayNotification(hourOfDay, minute);

            Snackbar snackbar = Snackbar
                    .make(mCoordinatorLayout, "Alarm Added", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            deleteAlarm(myAlarmManager.getNumberOfAlarms() - 1);

                            Snackbar
                                    .make(mCoordinatorLayout, "Alarm Deleted", Snackbar.LENGTH_SHORT)
                                    .show();
                        }
                    });

            snackbar.show();
        }
    };

    private void delayNotification(int alarmTimeHour, int alarmTimeMinute) {

        Alarm newAlarm = new Alarm(0, alarmTimeHour, alarmTimeMinute, "", true );

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimeHour);
        calendar.set(Calendar.MINUTE, alarmTimeMinute);

        myAlarmManager.addAlarm(newAlarm);
        alarmAdapter.add(newAlarm);

        int alarmID = (int) myAlarmManager.getAlarmAtPosition(myAlarmManager.getNumberOfAlarms()-1).getId();

        Intent alertIntent = new Intent(getContext(), MyReceiver.class);
        alertIntent.putExtra("alarmID", alarmID);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);


        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                PendingIntent
                        .getBroadcast(
                                getContext(),
                                alarmID,
                                alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        )
        );

        alarmAdapter.notifyDataSetChanged();
    }


    private void changeLabel(final int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Change Label");

        // Set up the input
        final EditText input = new EditText(getContext());

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                Alarm toChange = myAlarmManager.getAlarmAtPosition(pos);

                try {
                    toChange.setLabel(m_Text);

                    myAlarmManager.updateAlarmLabel(pos, m_Text);
                    alarmAdapter.clear();
                    alarmAdapter.addAll(myAlarmManager.getAlarms());

                } catch (Exception e) {
                    Log.i(TAG, String.valueOf(pos));
                    Log.e(TAG, String.valueOf(e));
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    private void deleteAlarmDialog(final int position){
        new AlertDialog.Builder(getContext())
                .setTitle("Delete Alarm")
                .setMessage("Are you sure you want to delete this alarm?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        Log.v("long clicked","Delete: " + position);
                        deleteAlarm(position);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        Log.v("long clicked","Do Nothing");

                    }
                })
                .show();
    }

    public void addAlarm(){
        pickTime();
    }

    public void deleteAlarm(int position){

        Alarm toRemove = myAlarmManager.getAlarmAtPosition(position);

        Intent alertIntent = new Intent(getContext(), MyReceiver.class);
        alertIntent.putExtra("alarmID", toRemove.getId());

        PendingIntent.getBroadcast(getContext(),(int) toRemove.getId(), alertIntent,
                PendingIntent.FLAG_UPDATE_CURRENT).cancel();


        alarmAdapter.remove(myAlarmManager.getAlarmAtPosition(position));
        myAlarmManager.removeAlarm(position);

        alarmAdapter.clear();
        alarmAdapter.addAll(myAlarmManager.getAlarms());
    }
}

