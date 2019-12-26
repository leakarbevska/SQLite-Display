package com.example.a21711436.tp2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessageDb {

    public static long add(String name, String dateTime, MessageDbOpener db) throws Exception {
        SQLiteDatabase sql_db = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MessageContract.COL_ID,System.currentTimeMillis());
        values.put(MessageContract.COL_TEXT, name);
        values.put(MessageContract.COL_DATETIME, dateTime);

        return sql_db.insert(MessageContract.BD_TABLE, null, values);
    }


    public static Cursor readAll(MessageDbOpener messageDbOpener){
        SQLiteDatabase db = messageDbOpener.getReadableDatabase();
        String[] projection = {MessageContract.COL_ID, MessageContract.COL_TEXT, MessageContract.COL_DATETIME};

        String selection = null; //MessageContract.COL_TEXT+ " = ?";
        String[] selectionArgs = null; //{""};
        String sortOrder = null; //MessageContract.COL_TEXT + " DESC";

        return db.query(
                MessageContract.BD_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
    }

    public static Cursor readLastFive(MessageDbOpener messageDbOpener){
        SQLiteDatabase db = messageDbOpener.getReadableDatabase();
        String[] projection = {MessageContract.COL_ID, MessageContract.COL_TEXT, MessageContract.COL_DATETIME};

        String selection = null; //MessageContract.COL_TEXT+ " = ?";
        String[] selectionArgs = null; //{""};
        String sortOrder = MessageContract.COL_ID + " DESC";

        return db.rawQuery("SELECT * FROM  "+ MessageContract.BD_TABLE+" ORDER BY "+MessageContract.COL_ID+" DESC LIMIT 5", null);

    }
}
