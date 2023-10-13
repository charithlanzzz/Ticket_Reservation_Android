package com.example.ticket_reservation_android.activities;// TrainsActivity.java
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ticket_reservation_android.R;

public class TrainsActivity extends AppCompatActivity {

    private ListView trainsListView;
    private String[] trainData; // Replace with your actual data


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains);

        // Replace trainData with your actual data
        trainData = new String[]{
                "Train 1",
                "Train 2",
                "Train 3",
                "Train 4",
                "Train 5",
        };

        // Initialize UI elements
        trainsListView = findViewById(R.id.trainsListView);

        // Create an adapter to display data in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.train_item, R.id.trainNameTextView, trainData);

        // Set the adapter to the ListView
        trainsListView.setAdapter(adapter);

        // Set click listener for the "Book" button
        trainsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTrain = trainData[position];
                // Extract train details and handle booking here
                // You can parse the selectedTrain string to get train information
                Toast.makeText(TrainsActivity.this, "Booking for: " + selectedTrain, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
