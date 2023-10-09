package com.example.ticket_reservation_android.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ticket_reservation_android.R;
import com.example.ticket_reservation_android.session.SessionManager;

public class LogoutActivity extends AppCompatActivity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        // Initialize SessionManager
        sessionManager = new SessionManager(this);

        // Call the logout method to clear the session
        sessionManager.logout();

        // Redirect the user to the login activity or any other desired activity
        Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity to prevent going back to it with the back button
    }
}

