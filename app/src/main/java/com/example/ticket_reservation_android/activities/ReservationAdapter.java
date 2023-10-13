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

public class ReservationAdapter extends ArrayAdapter<ReservationData> {

    private Context context;
    private int layoutResourceId;
    private List<ReservationData> reservationDataList;

    public ReservationAdapter(Context context, int layoutResourceId, List<ReservationData> reservationDataList) {
        super(context, layoutResourceId, reservationDataList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.reservationDataList = reservationDataList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ReservationDataHolder holder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ReservationDataHolder();
            holder.reservationNameTextView = row.findViewById(R.id.reservationNameTextView);
            holder.dateTextView = row.findViewById(R.id.dateTextView);
            holder.timeTextView = row.findViewById(R.id.timeTextView);
            holder.viewButton = row.findViewById(R.id.viewButton);

            row.setTag(holder);
        } else {
            holder = (ReservationDataHolder) row.getTag();
        }

        final ReservationData reservationData = reservationDataList.get(position);
        holder.reservationNameTextView.setText(reservationData.getReservationName());
        holder.dateTextView.setText(reservationData.getDate());
        holder.timeTextView.setText(reservationData.getTime());

        // Set click listener for the "Book" button
        holder.viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Book" button click here
                String selectedReservation = reservationDataList.get(position).getReservationName();
                // You can perform booking-related actions
            }
        });

        return row;
    }

    static class ReservationDataHolder {
        TextView reservationNameTextView;
        TextView dateTextView;
        TextView timeTextView;
        Button viewButton;
    }
}

