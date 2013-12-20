package com.assignment.hipstergram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String Table_ImageStore="imageStore";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_TITLE="title";
    public static final String COLUMN_LATITUDE="latitude";
    public static final String COLUMN_LONGITUDE ="longitude";
    public static final String COLUMN_PATH="path";
    public static final String COLUMN_DATE="date";
    public static final String DATABASE_NAME="db.imageSource";
    public static final int DATABASE_VERSION=1;
    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + Table_ImageStore + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TITLE
            + " text not null, "
            + COLUMN_LATITUDE +" TEXT, "
            + COLUMN_LONGITUDE+" TEXT, "
            + COLUMN_PATH+" TEXT, "
            +COLUMN_DATE+" TEXT);";

    public SQLiteHelper(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


