package com.testproject.wellthyuserviewer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.testproject.wellthyuserviewer.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prachi on 05/03/17.
 */

public class UserInfoDataSource {

    // Database fields
    private SQLiteDatabase database;
    private UserSQLiteHelper dbHelper;
    private String[] allColumns = { UserSQLiteHelper.COLUMN_ID,
            UserSQLiteHelper.COLUMN_NAME_USER_NAME,
            UserSQLiteHelper.COLUMN_NAME_USER_MOBILE
    };

    public UserInfoDataSource(Context context) {
        dbHelper = new UserSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean saveAllUsers(List<User> userList) {
        open();
        database.beginTransaction();

        try {
            for (User user : userList) {
                saveUser(user);
            }
            database.setTransactionSuccessful();
            return true;
        }
        catch (Exception e) {

        }
        finally {
            database.endTransaction();
            close();
        }

        return false;
    }

    private long saveUser(User user) {
        ContentValues values = new ContentValues();
        values.put(UserSQLiteHelper.COLUMN_NAME_USER_NAME, user.getName());
        values.put(UserSQLiteHelper.COLUMN_NAME_USER_MOBILE, user.getMobileNumber());

        //Insert values into DB
        long insertId = database.insert(UserSQLiteHelper.TABLE_NAME, null,
                values);
        return insertId;
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        open();

        Cursor cursor = database.query(UserSQLiteHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = cursorToImageInfo(cursor);
            userList.add(user);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return userList;
    }

    private User cursorToImageInfo(Cursor cursor) {
        User imageInfo = new User();
        imageInfo.setName(cursor.getString(1));
        imageInfo.setMobileNumber(cursor.getString(2));
        return imageInfo;
    }

}
