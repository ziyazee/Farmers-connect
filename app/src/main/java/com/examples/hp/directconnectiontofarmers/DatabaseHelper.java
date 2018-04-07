package com.examples.hp.directconnectiontofarmers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 04-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database name
    public static final String DATABASE_NAME="farmersConnect.db";

    //farmers Table
    public static final String TABLE_NAME3="farmerRegistration";
    public static final String COL_1f="ID";
    public static final String COL_2f="FarmerName";
    public static final String COL_3f="Password";
    public static final String COL_4f="Phone";
    public static final String COL_5f="Location";

    //items Table
    public static final String TABLE_NAME2="itemDetails";
    public static final String COL_1i="ID";
    public static final String COL_2i="item";
    public static final String COL_3i="description";
    public static final String COL_4i="price";
    public static final String COL_5i="farmername";
    public static final String COL_6i="phone";
    public static final String COL_7i="location";

    //Users Table
    public static final String TABLE_NAME="userRegisteration";
    public static final String COL_1="ID";
    public static final String COL_2="FirstName";
    public static final String COL_3="LastName";
    public static final String COL_4="Password";
    public static final String COL_5="Email";
    public static final String COL_6="Phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,  null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,item TEXT,description TEXT,price TEXT,farmername TEXT,phone TEXT,location TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FarmerName TEXT,Password TEXT,Phone TEXT,Location TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME); //Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME2);
       db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME3);
        //db.execSQL("DROP DATABASE " +DATABASE_NAME);

        //Drop older table if exists
//Drop older table if exists
        onCreate(db);

    }
}