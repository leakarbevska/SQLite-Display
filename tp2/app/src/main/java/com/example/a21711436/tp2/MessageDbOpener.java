package com.example.a21711436.tp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MessageDbOpener extends SQLiteOpenHelper {
    private static final String BD_CREATE = "CREATE TABLE tp2 " +
                                "( "+MessageContract.COL_ID+" INT NOT NULL,"+
                                    MessageContract.COL_TEXT +" VARCHAR(255),"+
                                    MessageContract.COL_DATETIME+" VARCHAR(255),"+
                                    "PRIMARY KEY ("+MessageContract.COL_ID+")"+
                                ");";

    public MessageDbOpener(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(BD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int a, int b){
        db.execSQL("DROP TABLE "+MessageContract.BD_TABLE);
        onCreate(db);
    }
}