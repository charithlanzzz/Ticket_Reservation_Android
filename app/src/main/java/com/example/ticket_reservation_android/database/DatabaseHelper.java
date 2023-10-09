package com.example.ticket_reservation_android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ticket_reservation_android.models.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAppDatabase";
    private static final int DATABASE_VERSION = 1;

    // Define table name and columns
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MOBILE_NUMBER = "mobile_number";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Create table SQL statement
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_MOBILE_NUMBER + " TEXT," +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_USERNAME + " TEXT," +
                    COLUMN_PASSWORD + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public long insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_MOBILE_NUMBER, user.getMobileNumber());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        // Insert the user data into the table
        long newRowId = db.insert(TABLE_USERS, null, values);
        db.close();
        return newRowId;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_MOBILE_NUMBER, COLUMN_EMAIL, COLUMN_USERNAME};

        Cursor cursor = db.query(TABLE_USERS, columns, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                int mobileNumberIndex = cursor.getColumnIndex(COLUMN_MOBILE_NUMBER);
                int emailIndex = cursor.getColumnIndex(COLUMN_EMAIL);
                int usernameIndex = cursor.getColumnIndex(COLUMN_USERNAME);

                if (idIndex >= 0 && nameIndex >= 0 && mobileNumberIndex >= 0 && emailIndex >= 0 && usernameIndex >= 0) {
                    String id = cursor.getString(idIndex);
                    String name = cursor.getString(nameIndex);
                    String mobileNumber = cursor.getString(mobileNumberIndex);
                    String email = cursor.getString(emailIndex);
                    String username = cursor.getString(usernameIndex);

                    User user = new User(id, name, mobileNumber, email, username);
                    userList.add(user);
                } else {
                    // Handle the case where one or more columns were not found
                    // You can log an error or handle it as needed.
                }
            }
            cursor.close();
        }

        return userList;
    }

    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_MOBILE_NUMBER, user.getMobileNumber());
        values.put(COLUMN_EMAIL, user.getEmail());

        // Update user data in the table
        int rowsAffected = db.update(TABLE_USERS, values, COLUMN_USERNAME + " = ?",
                new String[]{user.getUsername()});
        db.close();
        return rowsAffected;
    }

    // Add this method to DatabaseHelper.java
    public User getUserByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_MOBILE_NUMBER, COLUMN_EMAIL};
        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        User user = null;

        if (cursor != null && cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            int mobileNumberIndex = cursor.getColumnIndex(COLUMN_MOBILE_NUMBER);
            int emailIndex = cursor.getColumnIndex(COLUMN_EMAIL);

            if (nameIndex >= 0 && mobileNumberIndex >= 0 && emailIndex >= 0) {
                String name = cursor.getString(nameIndex);
                String mobileNumber = cursor.getString(mobileNumberIndex);
                String email = cursor.getString(emailIndex);

                user = new User(name, mobileNumber, email, username, password);
            } else {
                // Handle the case where one or more columns were not found
                // You can log an error or return a default user object, for example.
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        return user;
    }
    // ... (other methods)

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }
}
