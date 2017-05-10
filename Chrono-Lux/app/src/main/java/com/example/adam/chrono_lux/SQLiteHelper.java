package com.example.adam.chrono_lux;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Adam on 20/04/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ALARMS = "alarms";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_HOUR = "hour";
    public static final String COLUMN_MINUTE = "minute";
    public static final String COLUMN_LABEL = "label";
    public static final String COLUMN_SET = "isSet";

    private static final String DATABASE_NAME = "alarms.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_ALARMS + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_HOUR + " int not null,"
            + COLUMN_MINUTE + " int not null,"
            + COLUMN_LABEL + " text not null,"
            + COLUMN_SET + " int not null" // SQLite doesn't have bool, uses int 1 (true) 0 (false)
            + ");";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALARMS);
        onCreate(db);
    }

}
