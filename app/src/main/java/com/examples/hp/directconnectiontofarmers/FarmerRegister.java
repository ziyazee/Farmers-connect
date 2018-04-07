package com.examples.hp.directconnectiontofarmers;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerRegister extends AppCompatActivity {
Button b;
    SQLiteOpenHelper openHelper,openHelper2;
    SQLiteDatabase db;
    EditText _name,_pass,_phone,_loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_register);
        _name=(EditText)findViewById(R.id.name);
        openHelper = new DatabaseHelper(this);
        _pass=(EditText)findViewById(R.id.password);
        _phone=(EditText)findViewById(R.id.phone);
        _loc=(EditText)findViewById(R.id.location);
        b=(Button)findViewById(R.id.register);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String rname=_name.getText().toString();
                String rpass=_pass.getText().toString();
                String rphone=_phone.getText().toString();
                String rloc=_loc.getText().toString();
                insertdata(rname,rpass,rphone,rloc);
                Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FarmerRegister.this, MainActivity.class);
                startActivity(intent);
            }
            public void insertdata(String fname,String fpass,String fphone,String floc){
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COL_2f, fname);
                contentValues.put(DatabaseHelper.COL_3f, fpass);
                contentValues.put(DatabaseHelper.COL_4f, fphone);
                contentValues.put(DatabaseHelper.COL_5f, floc);
                long id = db.insert(DatabaseHelper.TABLE_NAME3, null, contentValues);
            }

     });


    }
}
