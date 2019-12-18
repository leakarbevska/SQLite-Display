package com.example.a21711436.tp2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView text_insert, text_item;
    Button   button_save;

    MessageDbOpener messageDbOpener;
    Cursor cursor;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_insert = (TextView)findViewById(R.id.text_insert);
        button_save = (Button)findViewById(R.id.button_save);
        listView    = (ListView)findViewById(R.id.list_insert);
        text_item   = (TextView) findViewById(R.id.text_item);

        this.messageDbOpener = new MessageDbOpener(this, MessageContract.BD_NAME, null, MessageContract.BD_VERSION);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "selected Item Name is " + text_item.getText(), Toast.LENGTH_LONG).show();

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.item_details_toast,
                        (ViewGroup) findViewById(R.id.parent));

                TextView text_id = (TextView) layout.findViewById(R.id.text_itemID);
                TextView text_date = (TextView) layout.findViewById(R.id.text_itemDate);
                TextView text_text = (TextView) layout.findViewById(R.id.text_itemText);
                text_id.setText("This is a custom toast");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

    }

    /*----------------------- BUTTON EVENTS --------------------*/
    public void save(View v){
        Calendar calendar = Calendar.getInstance();
        long id = -1;
        try {
            if(!this.text_insert.getText().toString().isEmpty()){
                id = MessageDb.add(this.text_insert.getText().toString(), String.valueOf(calendar.getTimeInMillis()), this.messageDbOpener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printToast(id);
        cleanInputText();
    }

    public void printLastMessages(View v){
        printList();
    }

    /*---------------------------- UTILS -----------------------------*/
    public void printToast(long id){
        if (id != -1) {
            Toast toast = Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }
    }

    public void cleanInputText(){
        this.text_insert.setText("");
    }

    public void printList(){
        Cursor cursor = MessageDb.readLastFive(this.messageDbOpener);
        SimpleCursorAdapter adapter =  new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] { MessageContract.COL_TEXT},
                new int[] { android.R.id.text1 });
    }

}
