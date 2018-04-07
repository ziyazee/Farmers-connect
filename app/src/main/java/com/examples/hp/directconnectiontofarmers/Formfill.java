package com.examples.hp.directconnectiontofarmers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 04-04-2018.
 */

public class Formfill extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="farming.db";
    public static final String TABLE_NAME="itemregistraion2";
    public static final String COL_1="ID";
    public static final String COL_2="Item";
    public static final String COL_3="FirstName";
    public static final String COL_4="Phone";

    public Formfill(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Item TEXT,FirstName TEXT,Phone TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME); //Drop older table if exists
        onCreate(db);
    }
}