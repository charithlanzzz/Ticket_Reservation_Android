package com.example.ticket_reservation_android.activities;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ticket_reservation_android.R;

public class DashboardActivity extends AppCompatActivity {
    private Button reservationsButton;
    private Button reserveTrainButton;
    private Button trainsButton;


    private void clearUserSession() {
        // Get a reference to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("userSession", MODE_PRIVATE);

        // Edit the SharedPreferences to clear user data
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Clear all data in the SharedPreferences
        editor.apply(); // Apply the changes

        // You may also want to redirect the user to the login page or perform other actions
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                // Handle logout action
                // For example, you can clear user session and navigate to the login page
                // Clear user session (You should implement your own logic for this)
                clearUserSession();

                // Navigate to the login page
                Intent loginIntent = new Intent(DashboardActivity.this, LoginActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(loginIntent);
                finish(); // Finish the dashboard activity
                return true;
            case R.id.action_profile:
                // Handle profile action
                // For example, you can navigate to the user's profile page
                // Navigate to the user details activity (You should replace UserDetailsActivity with the actual activity)
                Intent profileIntent = new Intent(DashboardActivity.this, UserDetailsActivity.class);
                startActivity(profileIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize UI elements
        CardView reservationsButton = findViewById(R.id.reservationsButton);
        CardView reserveTrainButton = findViewById(R.id.reserveTrainButton);
        CardView trainsButton = findViewById(R.id.trainsButton);

        // Set click listeners for dashboard buttons
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the ReservationsActivity
                Intent reservationsIntent = new Intent(DashboardActivity.this, ReservationsActivity.class);

                // Start the ReservationsActivity
                startActivity(reservationsIntent);
            }
        });

        reserveTrainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the ReservationsActivity
                Intent reserveIntent = new Intent(DashboardActivity.this, ReserveTrainActivity.class);

                // Start the ReservationsActivity
                startActivity(reserveIntent);

            }
        });

        trainsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the ReservationsActivity
                Intent reservationsIntent = new Intent(DashboardActivity.this, TrainsActivity.class);

                // Start the ReservationsActivity
                startActivity(reservationsIntent);
            }
        });


        // Handle back button presses using the onBackPressedDispatcher
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button press
                // In this example, we'll navigate to the user's profile instead of the login page
                Intent profileIntent = new Intent(DashboardActivity.this, UserDetailsActivity.class);
                startActivity(profileIntent);
                finish(); // Finish the DashboardActivity so the user can't navigate back to it
            }
        };

        // Add the callback to the onBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
