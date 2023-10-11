package com.example.ticket_reservation_android.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ticket_reservation_android.R;

import java.util.ArrayList;
import java.util.List;

public class ReserveTrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reserve);

        // Create a list of dummy reserve
        List<String> reserve = generateDummyReservations();

        // Initialize the ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reserve);

        // Find the ListView
        ListView reserveListView = findViewById(R.id.reserveListView);

        // Set the adapter to the ListView
        reserveListView.setAdapter(adapter);
    }

    // Generate dummy reservation data for testing
    private List<String> generateDummyReservations() {
        List<String> reserve = new ArrayList<>();

        // Add some dummy reserve
        reserve.add("Reservation 1 - Train 1 - Date 1");
        reserve.add("Reservation 2 - Train 2 - Date 2");
        reserve.add("Reservation 3 - Train 3 - Date 3");
        reserve.add("Reservation 4 - Train 4 - Date 4");

        return reserve;
    }
}

