package com.examples.hp.directconnectiontofarmers;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper,openHelper2;
    Cursor cursor;
    Button sub,b;
    EditText nam,pric, des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        nam=(EditText)findViewById(R.id.name);
        pric = (EditText) findViewById(R.id.price);
        des = (EditText) findViewById(R.id.desc);
        sub = (Button) findViewById(R.id.submit);
        b= (Button) findViewById(R.id.logout);

        openHelper = new DatabaseHelper(this);
        openHelper2=new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();


        Bundle bundle = getIntent().getExtras();
       final String stuff = bundle.getString("stuff");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form.this, MainActivity.class);
                startActivity(intent);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();


                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME3 + " WHERE " + DatabaseHelper.COL_2f + "=?", new String[]{stuff});


                cursor.moveToFirst();
                String ifarmername=cursor.getString(cursor.getColumnIndex("FarmerName"));
                String  iphone=cursor.getString(cursor.getColumnIndex("Phone"));
                String  iloc=cursor.getString(cursor.getColumnIndex("Location"));


                String iprice= pric.getText().toString();
                String iname= nam.getText().toString();

                String idesc= des.getText().toString();


//                String pass = des.getText().toString();
                insertdata(iname,idesc,iprice,ifarmername,iphone,iloc);
                Toast.makeText(getApplicationContext(), "item added successfully",Toast.LENGTH_LONG).show();
            }
            public void insertdata(String item, String description, String price, String farmername,String phone,String location){
                ContentValues contentValues = new ContentValues();

                contentValues.put(DatabaseHelper.COL_2i, item);
                contentValues.put(DatabaseHelper.COL_3i, description);
                contentValues.put(DatabaseHelper.COL_4i, price);
                contentValues.put(DatabaseHelper.COL_5i, farmername);
                contentValues.put(DatabaseHelper.COL_6i, phone);
                contentValues.put(DatabaseHelper.COL_7i, location);
                long id = db.insert(DatabaseHelper.TABLE_NAME2, null, contentValues);
            }

        });

//
//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = pric.getText().toString();
//                String pass = des.getText().toString();
//
//
//            }
//        });
    }
}
//    SQLiteDatabase db;
//    SQLiteOpenHelper openHelper;
//    Cursor cursor;
//    Button _btnLogin;
//    EditText _txtEmail, _txtPass;
//TextView t;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_form);
//        Bundle bundle = getIntent().getExtras();
//
//
//        String stuff = bundle.getString("stuff");
//        t=(TextView)findViewById(R.id.txt);
//        t.setText(stuff);
//
//    }
//}
