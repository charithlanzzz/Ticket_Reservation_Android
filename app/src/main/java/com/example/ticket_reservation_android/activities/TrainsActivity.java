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

public class TrainsActivity extends AppCompatActivity {

    private ListView trainsListView;
    private List<TrainData> trainDataList;
    private TrainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains);

        // Initialize UI elements
        trainsListView = findViewById(R.id.trainsListView);

        // Create a list of dummy train data
        trainDataList = new ArrayList<>();
        trainDataList.add(new TrainData("GreenTrain", "2023.05.25", "01.36PM"));
        trainDataList.add(new TrainData("BlueTrain", "2023.05.27", "02.46PM"));
        trainDataList.add(new TrainData("RedTrain", "2023.07.24", "08.56PM"));
        trainDataList.add(new TrainData("YellowTrain", "2023.08.22", "04.36PM"));
        trainDataList.add(new TrainData("PurpleTrain", "2023.05.25", "04.58PM"));

        // Initialize the custom adapter
        adapter = new TrainAdapter(this, R.layout.train_item, trainDataList);

        // Set the adapter to the ListView
        trainsListView.setAdapter(adapter);

        // Set item click listener
        trainsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTrain = trainDataList.get(position).getTrainName();
                // Handle booking or any other action here
                Toast.makeText(TrainsActivity.this, "Booking for: " + selectedTrain, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
