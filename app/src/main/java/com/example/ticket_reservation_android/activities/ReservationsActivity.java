package com.example.ticket_reservation_android.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ticket_reservation_android.R;

import java.util.ArrayList;
import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    private ListView reservationsListView;
    private List<ReservationData> reservationDataList;
    private ReservationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        // Initialize UI elements
        reservationsListView = findViewById(R.id.reservationsListView);

        // Create a list of dummy reservation data
        reservationDataList = new ArrayList<>();
        reservationDataList.add(new ReservationData("GreenTrain", "2023.05.25", "01.36PM"));
        reservationDataList.add(new ReservationData("BlueTrain", "2023.05.27", "02.46PM"));
        reservationDataList.add(new ReservationData("RedTrain", "2023.07.24", "08.56PM"));
        reservationDataList.add(new ReservationData("YellowTrain", "2023.08.22", "04.36PM"));
        reservationDataList.add(new ReservationData("PurpleTrain", "2023.05.25", "04.58PM"));

        // Initialize the custom adapter
        adapter = new ReservationAdapter(this, R.layout.reservation_item, reservationDataList);

        // Set the adapter to the ListView
        reservationsListView.setAdapter(adapter);

        // Set item click listener
        reservationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTrain = reservationDataList.get(position).getReservationName();
                // Handle booking or any other action here
                Toast.makeText(ReservationsActivity.this, "Booking for: " + selectedTrain, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
