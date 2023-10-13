package com.example.ticket_reservation_android.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.ticket_reservation_android.R;

import java.util.List;

public class TrainAdapter extends ArrayAdapter<TrainData> {

    private Context context;
    private int layoutResourceId;
    private List<TrainData> trainDataList;

    public TrainAdapter(Context context, int layoutResourceId, List<TrainData> trainDataList) {
        super(context, layoutResourceId, trainDataList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.trainDataList = trainDataList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TrainDataHolder holder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TrainDataHolder();
            holder.trainNameTextView = row.findViewById(R.id.trainNameTextView);
            holder.dateTextView = row.findViewById(R.id.dateTextView);
            holder.timeTextView = row.findViewById(R.id.timeTextView);
            holder.bookButton = row.findViewById(R.id.bookButton);

            row.setTag(holder);
        } else {
            holder = (TrainDataHolder) row.getTag();
        }

        final TrainData trainData = trainDataList.get(position);
        holder.trainNameTextView.setText(trainData.getTrainName());
        holder.dateTextView.setText(trainData.getDate());
        holder.timeTextView.setText(trainData.getTime());

        // Set click listener for the "Book" button
        holder.bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Book" button click here
                String selectedTrain = trainDataList.get(position).getTrainName();
                // You can perform booking-related actions
            }
        });

        return row;
    }

    static class TrainDataHolder {
        TextView trainNameTextView;
        TextView dateTextView;
        TextView timeTextView;
        Button bookButton;
    }
}

