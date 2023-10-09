package com.example.ticket_reservation_android.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.ticket_reservation_android.R;

public class DashboardActivity extends AppCompatActivity {
    private Button reservationsButton;
    private Button reserveTrainButton;
    private Button trainsButton;

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
                // Handle reservations button click
                // You can navigate to the reservations screen or perform other actions here
            }
        });

        reserveTrainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle reserve a train button click
                // You can navigate to the train reservation screen or perform other actions here
            }
        });

        trainsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle trains button click
                // You can navigate to the trains screen or perform other actions here
            }
        });
    }
}
