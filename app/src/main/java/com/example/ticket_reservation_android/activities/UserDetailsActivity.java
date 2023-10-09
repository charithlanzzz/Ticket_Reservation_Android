package com.example.ticket_reservation_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
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

        // Make the usernameEditText non-focusable and non-clickable
        usernameEditText.setFocusable(false);
        usernameEditText.setFocusableInTouchMode(false);
        usernameEditText.setClickable(false);

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

        // Set a click listener for the update button
        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle update logic here
                String name = nameEditText.getText().toString();
                String mobileNumber = mobileEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();

                // Create a User object with updated details
                User updatedUser = new User(name, mobileNumber, email, username, "");

                // Update the user in the database
                int rowsAffected = dbHelper.updateUser(updatedUser);

                if (rowsAffected > 0) {
                    // Update successful, save the updated user to the session
                    sessionManager.saveSession(updatedUser);

                    // Display a success message
                    Toast.makeText(UserDetailsActivity.this, "User details updated", Toast.LENGTH_SHORT).show();
                } else {
                    // Display an error message
                    Toast.makeText(UserDetailsActivity.this, "Failed to update user details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        dbHelper.close();
    }

}
