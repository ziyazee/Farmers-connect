package com.examples.hp.directconnectiontofarmers;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity  {
Button b;
    TextView t;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper2;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> ITEM_ArrayList = new ArrayList<String>();
    ArrayList<String> DESCRIPTION_ArrayList = new ArrayList<String>();
    ArrayList<String> PRICE_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> PHONE_ArrayList = new ArrayList<String>();
    ArrayList<String> LOCATION_ArrayList = new ArrayList<String>();
    ArrayList<String> ID_ArrayList = new ArrayList<String>();


    ListView LISTVIEW;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        t=(TextView)findViewById(R.id.txxt);
        b=(Button)findViewById(R.id.bttn);
        t.setText("Items available for today");


        LISTVIEW = (ListView) findViewById(R.id.listView1);

        openHelper2 = new DatabaseHelper(this);
        db = openHelper2.getReadableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        db=openHelper2.getWritableDatabase();

        cursor = db.rawQuery("SELECT * from "+DatabaseHelper.TABLE_NAME2,null);
        ID_ArrayList.clear();
        ITEM_ArrayList.clear();
        DESCRIPTION_ArrayList.clear();
        PRICE_ArrayList.clear();
        NAME_ArrayList.clear();
        PHONE_ArrayList.clear();
        LOCATION_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_1i)));

                ITEM_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2i)));
                DESCRIPTION_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3i)));
                PRICE_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4i)));
                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_5i)));
                PHONE_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_6i)));
                LOCATION_ArrayList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_7i)));


            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListViewActivity.this,
                ID_ArrayList,
                ITEM_ArrayList,
                DESCRIPTION_ArrayList,
                PRICE_ArrayList,
                NAME_ArrayList,
                PHONE_ArrayList,
                LOCATION_ArrayList

        );

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();




    }

}