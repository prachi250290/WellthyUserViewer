package com.testproject.wellthyuserviewer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prachi on 05/03/17.
 */

public class UserSQLiteHelper extends SQLiteOpenHelper{

    //Table name
    public static final String TABLE_NAME = "User";

    //Column names
    public static final String COLUMN_NAME_USER_NAME = "name";
    public static final String COLUMN_NAME_USER_MOBILE = "mobileNumber";
    public static final String COLUMN_ID = "_id";


    //DB info
    private static final String DATABASE_NAME = "userdatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table if not exists "
            + TABLE_NAME + "( " + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME_USER_NAME + " text ,"
            + COLUMN_NAME_USER_MOBILE + " text "
            +");";

    public UserSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
