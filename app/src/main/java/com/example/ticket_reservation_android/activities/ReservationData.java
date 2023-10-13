package com.example.ticket_reservation_android.activities;

public class ReservationData {
    private String reservationName;
    private String date;
    private String time;

    public ReservationData(String reservationName, String date, String time) {
        this.reservationName = reservationName;
        this.date = date;
        this.time = time;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

