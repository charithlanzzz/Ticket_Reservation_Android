package com.example.ticket_reservation_android.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ticket_reservation_android.R;

import java.util.ArrayList;
import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        // Create a list of dummy reservations
        List<String> reservations = generateDummyReservations();

        // Initialize the ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reservations);

        // Find the ListView
        ListView reservationsListView = findViewById(R.id.reservationsListView);

        // Set the adapter to the ListView
        reservationsListView.setAdapter(adapter);
    }

    // Generate dummy reservation data for testing
    private List<String> generateDummyReservations() {
        List<String> reservations = new ArrayList<>();

        // Add some dummy reservations
        reservations.add("Reservation 1 - Train 1 - Date 1");
        reservations.add("Reservation 2 - Train 2 - Date 2");
        reservations.add("Reservation 3 - Train 3 - Date 3");
        reservations.add("Reservation 4 - Train 4 - Date 4");

        return reservations;
    }
}

