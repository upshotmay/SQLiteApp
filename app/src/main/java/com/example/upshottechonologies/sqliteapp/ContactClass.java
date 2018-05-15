package com.example.upshottechonologies.sqliteapp;

public class ContactClass {

    public static final String DB_NAME ="upshot";
    public static final int VERSION = 1;

    public static final String TABLE_NAME = "ContactTbl";
    public static final String ID = "id";
    public static final String NAME = "Name";
    public static final String PHONE = "Phone";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            NAME + " TEXT ," + PHONE + " TEXT )";


}
