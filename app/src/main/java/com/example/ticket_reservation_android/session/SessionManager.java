package com.example.ticket_reservation_android.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ticket_reservation_android.models.User;

public class SessionManager {
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_LOGGED_IN = "loggedIn";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE_NUMBER = "mobileNumber";
    private static final String KEY_EMAIL = "email";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        if (user != null) {
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_MOBILE_NUMBER, user.getMobileNumber());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putBoolean(KEY_LOGGED_IN, true);
        editor.apply();
        }
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public String getName() {
        return sharedPreferences.getString(KEY_NAME, "");
    }

    public String getMobileNumber() {
        return sharedPreferences.getString(KEY_MOBILE_NUMBER, "");
    }

    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, "");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public User getUserDetails() {
        String username = sharedPreferences.getString(KEY_USERNAME, "");
        String name = sharedPreferences.getString(KEY_NAME, "");
        String mobileNumber = sharedPreferences.getString(KEY_MOBILE_NUMBER, "");
        String email = sharedPreferences.getString(KEY_EMAIL, "");

        return new User(name, mobileNumber, email, username, "");
    }
}
