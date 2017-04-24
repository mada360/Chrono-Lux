package com.example.adam.chrono_lux.alarm;

/**
 * Created by Adam on 20/04/2017.
 */

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.adam.chrono_lux.SQLiteHelper;
import com.example.adam.chrono_lux.alarm.Alarm;


public class AlarmDataSource {
    private final String TAG = "AlarmDataSource";

    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            SQLiteHelper.COLUMN_ID,
            SQLiteHelper.COLUMN_HOUR,
            SQLiteHelper.COLUMN_MINUTE,
            SQLiteHelper.COLUMN_LABEL,
            SQLiteHelper.COLUMN_SET,
    };

    public AlarmDataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Alarm createAlarm(Alarm alarm) {
        ContentValues values = new ContentValues();


        values.put(SQLiteHelper.COLUMN_HOUR, alarm.getHour());
        values.put(SQLiteHelper.COLUMN_MINUTE, alarm.getMinute());
        values.put(SQLiteHelper.COLUMN_LABEL, alarm.getLabel());
        values.put(SQLiteHelper.COLUMN_SET, alarm.isSet());

        long insertId = database.insert(SQLiteHelper.TABLE_ALARMS, null,
                values);

        alarm.setId(insertId);


        Cursor cursor = database.query(SQLiteHelper.TABLE_ALARMS,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Alarm newAlarm = cursorToAlarm(cursor);
        cursor.close();
        return newAlarm;
    }

    public void deleteAlarm(Alarm alarm) {
        long id = alarm.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(SQLiteHelper.TABLE_ALARMS, SQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public ArrayList<Alarm> getAlarms() {
        ArrayList<Alarm> alarms = new ArrayList<>();

        try {
            Cursor cursor = database.query(SQLiteHelper.TABLE_ALARMS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Alarm alarm = cursorToAlarm(cursor);
                alarms.add(alarm);
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();

            Log.i(TAG, String.valueOf(alarms.size()));
        } catch (Exception e){
            Log.e(TAG, String.valueOf(e));
        }
        return alarms;
    }

    private Alarm cursorToAlarm(Cursor cursor) {
        Alarm alarm = new Alarm();
        alarm.setId(cursor.getInt(0));
        alarm.setHour(cursor.getInt(1));
        alarm.setMinute(cursor.getInt(2));
        alarm.setLabel(cursor.getString(3));

        if (cursor.getInt(4) == 1){
            alarm.setSet(true);
        }else {
            alarm.setSet(false);
        }

        return alarm;
    }

    public boolean updateAlarmLabel(long rowId, String label) {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_LABEL, label);

        // Table, values, string whereClaus, whereArgs
        return database.update(SQLiteHelper.TABLE_ALARMS, values, SQLiteHelper.COLUMN_ID + "=" + rowId, null) > 0;
    }

    public boolean updateAlarmSet(long rowId, boolean isSet) {
        ContentValues values = new ContentValues();

        int set;
        if (isSet){
            set = 1;
        }else{
            set = 0;
        }

        values.put(SQLiteHelper.COLUMN_SET, set);

        // Table, values, string whereClaus, whereArgs
        return database.update(SQLiteHelper.TABLE_ALARMS, values, SQLiteHelper.COLUMN_ID + "=" + rowId, null) > 0;
    }

}
