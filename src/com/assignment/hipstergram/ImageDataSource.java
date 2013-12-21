package com.assignment.hipstergram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
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
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_TITLE, picInfo.getTitle());
        values.put(SQLiteHelper.COLUMN_LATITUDE,picInfo.getLatitude());
        values.put(SQLiteHelper.COLUMN_LONGITUDE,picInfo.getLongitude());
        values.put(SQLiteHelper.COLUMN_PATH,picInfo.getPath());
        values.put(SQLiteHelper.COLUMN_DATE,picInfo.getDate());

        long insertId = database.insert(SQLiteHelper.Table_ImageStore, null,
                values);
        //Cursor cursor = database.query(SQLiteHelper.Table_ImageStore,
          //      allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null,
            //    null, null, null);
        //cursor.moveToFirst();
       // ImageBlock newComment = cursorToImageBlock(cursor);
        //cursor.close();
     //   return newComment;

    }

    private ImageBlock cursorToImageBlock(Cursor cursor) {
        ImageBlock picInfo = new ImageBlock();
        picInfo.setId(cursor.getLong(0));
        picInfo.setTitle(cursor.getString(1));
        picInfo.setLatitude(cursor.getString(2));
        picInfo.setLongitude(cursor.getString(3));
        picInfo.setPath(cursor.getString(4));
        picInfo.setDate(cursor.getString(5));
        return picInfo;
    }

    public List<ImageBlock> getAllImagesInfo() {
        List<ImageBlock> comments = new ArrayList<ImageBlock>();

        Cursor cursor = database.query(SQLiteHelper.Table_ImageStore,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ImageBlock comment = cursorToImageBlock(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    public void deleteImage(Long id) {
        database.delete(SQLiteHelper.Table_ImageStore, SQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }
}
