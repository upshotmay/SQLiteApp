package com.example.upshottechonologies.sqliteapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DBHelper extends SQLiteOpenHelper {

    //public static final String DB_NAME = "";
    DBHelper(Context context)
    {
        super(context, ContactClass.DB_NAME, null, ContactClass.VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactClass.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ContactClass.TABLE_NAME);
        onCreate(db);
        onUpgrade(db, oldVersion, newVersion);
    }

    public Long insert(String name, String phone)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactClass.NAME, name);
        contentValues.put(ContactClass.PHONE, phone);
        SQLiteDatabase db = this.getWritableDatabase();
        Long ret = db.insert(ContactClass.TABLE_NAME, null, contentValues);
        db.close();
        return ret;

    }

    public String fetch()
    {
        String sql = "SELECT "+ContactClass.NAME +" FROM "+ContactClass.TABLE_NAME+ " WHERE "+ContactClass.ID+"=3";
        String SQLSelect = "SELECT * FROM "+ ContactClass.TABLE_NAME;
        Cursor cursor;
        String res ="";
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery(SQLSelect, null);
        while (cursor.moveToNext())
        {
            res+="ID:"+cursor.getInt(0)+" Name:"+cursor.getString(1)+ " Phone:"+cursor.getInt(2)+"\n";
            //System.out.println("ID:"+cursor.getInt(0)+ "\n Name:"+cursor.getString(1)+ "\n Phone:"+ cursor.getString(2));
        }
        return res;
    }

    public void update(String name, String phone, int id)
    {
        String sql = "UPDATE "+ContactClass.TABLE_NAME + " SET "+
                ContactClass.NAME +"="+"'"+name +"'"+ ","+ContactClass.PHONE+"="+"'"+phone+"'" + " WHERE "+
                ContactClass.ID+"="+id;

        String sql2 = "UPDATE "+ContactClass.TABLE_NAME + " SET "+ ContactClass.NAME+"=?, "+ContactClass.PHONE+"=? WHERE "+ContactClass.ID+"="+id;

        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL(sql);
        db.execSQL(sql2, new String[]{name, phone});

    }

    public void delete(int id)
    {
        String sql = "DELETE FROM "+ContactClass.TABLE_NAME +" WHERE "+ContactClass.ID+"="+id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
