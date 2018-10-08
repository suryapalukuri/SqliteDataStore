package com.example.admin.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Database extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="sample_db";
    private static final String SNAME ="SNAME";
    private static final String RNUM ="RNUM";
    private static final String NUM ="NUM" ;
    private static final String STUDENT ="STUDENT";


    public Database(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+STUDENT+"("+SNAME+"TEXT,"+RNUM+"TEXT,"+NUM+"TEXT"+")");

        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STUDENT);
        onCreate(sqLiteDatabase);

    }

    public void insert(String sname, String srnum, String snum) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(SNAME,sname);

        contentValues.put(RNUM,srnum);

        contentValues.put(NUM,snum);

        sqLiteDatabase.insert(STUDENT,null, contentValues);
    }
}
