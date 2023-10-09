package com.example.ticket_reservation_android.activities;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ticket_reservation_android.R;
import com.example.ticket_reservation_android.database.DatabaseHelper;
import com.example.ticket_reservation_android.models.User;
import com.example.ticket_reservation_android.session.SessionManager;

public class UserDetailsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText emailEditText;
    private EditText usernameEditText;

    private DatabaseHelper dbHelper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        // Initialize EditText views
        nameEditText = findViewById(R.id.nameEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameEditText = findViewById(R.id.usernameEditText);

        // Initialize DatabaseHelper and SessionManager
        dbHelper = new DatabaseHelper(this);
        sessionManager = new SessionManager(this);

        // Retrieve user details from the session
        User currentUser = sessionManager.getUserDetails();

        // Display user details if available
        if (currentUser != null) {
            nameEditText.setText(currentUser.getName());
            mobileEditText.setText(currentUser.getMobileNumber());
            emailEditText.setText(currentUser.getEmail());
            usernameEditText.setText(currentUser.getUsername());
        } else {
            // Handle the case where no user details are found in the session
            // You can display an error message or perform any other desired action
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        dbHelper.close();
    }
}
