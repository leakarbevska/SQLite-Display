package com.example.a21711436.tp2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView text_insert;
    Button   button_save;

    MessageDbOpener messageDbOpener;
    MessageContract messageContract;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_insert = (TextView)findViewById(R.id.text_insert);
        button_save = (Button)findViewById(R.id.button_save);

        this.messageContract = new MessageContract(this);
        this.cursor = this.messageContract.getNoms();
        SQLiteDatabase dbSQL = this.messageDbOpener.getWritableDatabase();
    }

    public void save(View v){
        Calendar calendar = Calendar.getInstance();
        try {
            MessageDb.ajouter(text_insert.getText().toString(), String.valueOf(calendar.getTimeInMillis()), this.messageDbOpener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printToast();
    }

    public void printToast(){
        if (this.cursor.moveToLast()) {
            int id = cursor.getInt(0);
            Toast toast=Toast. makeText(getApplicationContext(), id, Toast.LENGTH_SHORT);
            toast. setMargin(50,50);
            toast. show();
        }
    }
}
