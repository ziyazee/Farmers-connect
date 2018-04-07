package com.examples.hp.directconnectiontofarmers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerLogin extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnLogin;
    EditText _txtname, _txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);
        _txtname=(EditText)findViewById(R.id.fname);
        _txtPass=(EditText)findViewById(R.id.fPass);
        _btnLogin=(Button)findViewById(R.id.fLogin);
        openHelper=new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _txtname.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME3 + " WHERE " + DatabaseHelper.COL_2f + "=? AND " + DatabaseHelper.COL_3f + "=?", new String[]{name, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Intent i = new Intent(FarmerLogin.this, Form.class);

                        String getrec=_txtname.getText().toString();
                        Bundle bundle = new Bundle();
                        bundle.putString("stuff", getrec);
                        i.putExtras(bundle);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}