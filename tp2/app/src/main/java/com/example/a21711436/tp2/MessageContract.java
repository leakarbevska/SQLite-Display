package com.example.a21711436.tp2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessageContract {
    private MessageDbOpener db;
    public static final String BD_NAME = "tp2.db";
    private static final int BD_VERSION = 1;

    public static final String BD_TABLE = "tp2";
    public static final String COL_ID   = "_id";
    public static final String COL_TEXT = "text";
    public static final String COL_DATETIME = "dateTime";

    public MessageContract(Context context) {
        this.db = new MessageDbOpener(context, BD_NAME, null, BD_VERSION);
    }

}
