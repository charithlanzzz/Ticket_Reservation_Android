package com.example.ticket_reservation_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ticket_reservation_android.R;
import com.example.ticket_reservation_android.database.DatabaseHelper;
import com.example.ticket_reservation_android.models.User;
import com.example.ticket_reservation_android.session.SessionManager; // Import the SessionManager class

public class RegistrationActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;

    private DatabaseHelper databaseHelper;
    private SessionManager sessionManager; // Initialize SessionManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Initialize SessionManager
        sessionManager = new SessionManager(getApplicationContext());

        // Set click listener for registerButton
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String name = nameEditText.getText().toString().trim();
                String mobile_number = mobileEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input
                if (name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a User object
                    User user = new User(name, mobile_number, email, username, password);

                    // Insert user into the database
                    long newRowId = databaseHelper.insertUser(user);

                    if (newRowId != -1) {
                        // User insertion successful
                        Toast.makeText(RegistrationActivity.this, "User registration successful", Toast.LENGTH_SHORT).show();

                        // Save the session with the full user details
                        sessionManager.saveSession(user);

                        // Navigate to the login page or DashboardActivity
                        if (sessionManager.isLoggedIn()) {
                            // User is already logged in, navigate to DashboardActivity
                            Intent intent = new Intent(RegistrationActivity.this, DashboardActivity.class);
                            startActivity(intent);
                        } else {
                            // User is not logged in, navigate to LoginActivity
                            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        finish(); // Finish the current activity
                    } else {
                        // User insertion failed
                        Toast.makeText(RegistrationActivity.this, "User registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
