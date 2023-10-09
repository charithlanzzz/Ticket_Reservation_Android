package com.example.ticket_reservation_android.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.example.ticket_reservation_android.R;
import com.example.ticket_reservation_android.database.DatabaseHelper;
import com.example.ticket_reservation_android.models.User;
import com.example.ticket_reservation_android.session.SessionManager;

public class LoginActivity extends AppCompatActivity {

//    SessionManager sessionManager = new SessionManager(getApplicationContext());
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private DatabaseHelper databaseHelper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Initialize SessionManager here, using the activity context
        sessionManager = new SessionManager(this);


        // Set a click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login logic here
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check credentials
                User user = databaseHelper.getUserByUsernameAndPassword(username, password);

                sessionManager.saveSession(user);

                if (user != null) {
                    // If credentials are valid, navigate to another activity (e.g., DashboardActivity)
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    // You can add code here to start the DashboardActivity or any other desired activity
                } else {
                    // Display an error message or handle authentication failure
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button createAccountButton = findViewById(R.id.createAccountLink);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegistrationActivity
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
