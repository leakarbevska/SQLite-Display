package com.example.a21711436.tp2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessageDb {

    public static long add(String name, String dateTime, MessageDbOpener db) throws Exception {
        SQLiteDatabase sql_db = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MessageContract.COL_TEXT, name);
        values.put(MessageContract.COL_DATETIME, dateTime);


        return sql_db.insert(MessageContract.BD_TABLE, null, values);
    }

    public static void readLast(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {MessageContract.COL_ID, MessageContract.COL_TEXT, MessageContract.COL_DATETIME};


        String selection = MessageContract.COL_TEXT+ " = ?";
        String[] selectionArgs = {""};
        String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                MessageContract.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

    }
}
