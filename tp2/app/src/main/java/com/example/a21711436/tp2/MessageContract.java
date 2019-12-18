package com.example.a21711436.tp2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessageContract {
    public static final String BD_NAME = "tp2.db";
    public static final int BD_VERSION = 1;

    public static final String BD_TABLE = "tp2";
    public static final String COL_ID   = "_id";
    public static final String COL_TEXT = "text";
    public static final String COL_DATETIME = "dateTime";

}
