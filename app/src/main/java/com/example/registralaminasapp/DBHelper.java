package com.example.registralaminasapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="registro.db";

    public DBHelper(Context context) {
        super(context, "registro.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    //ingresar datos de nuevo usuario
    public Boolean insertData(String username, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result=db.insert("users", null, values);
        if (result==-1) return false;
        else
            return true;
    }

    //revisar nombre de usuario
    public Boolean checkusername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //revisar nombre de usuario
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
