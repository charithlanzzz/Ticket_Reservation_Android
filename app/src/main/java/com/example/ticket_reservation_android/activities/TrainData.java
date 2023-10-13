package com.example.ticket_reservation_android.activities;

public class TrainData {
    private String trainName;
    private String date;
    private String time;

    public TrainData(String trainName, String date, String time) {
        this.trainName = trainName;
        this.date = date;
        this.time = time;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

