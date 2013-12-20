package com.assignment.hipstergram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.List;

public class ImageDataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns={
            SQLiteHelper.COLUMN_ID,
            SQLiteHelper.COLUMN_TITLE,
            SQLiteHelper.COLUMN_LATITUDE,
            SQLiteHelper.COLUMN_LONGITUDE,
            SQLiteHelper.COLUMN_PATH,
            SQLiteHelper.COLUMN_DATE
            };

    public ImageDataSource(Context context) {
        dbHelper=new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void saveImage(ImageBlock picInfo ) {

    }

    public List<ImageBlock> getAllImagesInfo() {
        return null;
    }

    public void deleteImage(Long id) {

    }
}
