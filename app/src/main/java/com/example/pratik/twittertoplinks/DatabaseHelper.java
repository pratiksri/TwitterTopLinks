package com.example.pratik.twittertoplinks;

/**
 * Created by Pratik on 05/12/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pratik on 07/07/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL("CREATE table IF NOT EXISTS "+ TABLE_NAME +" ( "+ COL1 +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL2 + " TEXT, "+ COL3 + " TEXT, " + COL4 + " TEXT)");
        // db.execSQL("DROP TABLE notices");
        db.execSQL("CREATE TABLE IF NOT EXISTS tweets(user varchar, text varchar);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //this method will add users in the database
    public void insertItem(String user, String text){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO tweets VALUES ('"+String.valueOf(user)+"','"+String.valueOf(text)+"');");
        ContentValues contentvalues = new ContentValues();
//        contentvalues.put(COL2, from);
//        contentvalues.put(COL3, to);
//        contentvalues.put(COL4, status);
//        db.insert(TABLE_NAME, null, contentvalues);

    }


    //get all the users in the database
    public Cursor getAll(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT * from tweets",null);
        return cursor;
    }

    public void deleteRecord(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE from tweets");
    }
}